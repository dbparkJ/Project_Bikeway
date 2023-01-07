package corse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import db.DBConnection;

public class CorseDAO {
	//싱글톤 객체
	private static CorseDAO instance=new CorseDAO();
	
	//생성자
	private CorseDAO(){}
	
	public static CorseDAO getDao(){ //jsp 사용할 메서드
		return instance;
	}
	
	//전역변수 선언
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	/*
	 * 한개의 코스의 데이터를 불러온다
	 */
	
	
	public List<CorseDTO> getAllCorseList(){
		//List<CorseDTO> allCorse = null;
		JSONArray array = new JSONArray();
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("select * from corse where corse_name= '여주ic-농부부'");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
		    	JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	obj.put("elev", rs.getLong("elev"));
		        obj.put("lon", rs.getLong("lon"));
		        obj.put("lat", rs.getLong("lat"));
		        obj.put("corse_name", rs.getString("corse_name"));	// obj.put("key","value")
		        array.add(obj);	//작성한 JSON 객체를 배열에 추가
		    }
			
		}catch(Exception ex) {
			System.out.println("getAllCorseList()예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return array;
	}//getAllCorseList-end
	
	
	/*
	 * 한개의 코스의 데이터를 불러온다
	 */
	
	
	public List<CorseDTO> getSingleCorseList(String corse){
		List<CorseDTO> singleCorse = null;
		try {
			
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("select corse, lat, lon from corse where corse=?");
			pstmt.setString(1, corse);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				singleCorse=new ArrayList();
				do{	//rs.next로 하나를 받았으므로 do-while 사용
					CorseDTO dto=new CorseDTO();
					dto.setCorse_name(rs.getString("corse"));

					singleCorse.add(dto);
				}while(rs.next());
			}//if-end
			
			
		}catch(Exception ex) {
			System.out.println("getSingleCorseList()예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return singleCorse;
	}//getSingleCorseList-end

}//CorseDAO-end
