package corse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		List<CorseDTO> allCorse = null;
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement("select * from corse where corse= '소말송추됫박' ");
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				allCorse=new ArrayList();
				do{	//rs.next로 하나를 받았으므로 do-while 사용
					CorseDTO dto=new CorseDTO();
					dto.setCorse(rs.getString("corse"));


					allCorse.add(dto);
				}while(rs.next());
			}//if-end
		}catch(Exception ex) {
			System.out.println("getAllCorseList()예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return allCorse;
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
					dto.setCorse(rs.getString("corse"));

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
