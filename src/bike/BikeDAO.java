package bike;

import java.net.http.HttpRequest;
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

public class BikeDAO {
	//싱글톤 객체
	private static BikeDAO instance=new BikeDAO();
	
	//생성자
	private BikeDAO(){}
	
	public static BikeDAO getDao(){ //jsp 사용할 메서드
		return instance;
	}
	
	//전역변수 선언
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	

//==============================================================================================	

/*
* 코스관련 DAO
*/

//코스리스트 생성	
	public List<CorseDTO> getCorseList(){
		List<CorseDTO> singleCorseList = null;
		try {
			con = DBConnection.getInstacne().getConnection();
			pstmt = con.prepareStatement("select corse_name from corse group by corse_name");
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				singleCorseList=new ArrayList<CorseDTO>();
				do{	
					CorseDTO dto=new CorseDTO();

					dto.setCorse_name(rs.getString("corse_name"));

					singleCorseList.add(dto); //***

				}while(rs.next());
			}//if-end
			
			
		}catch(Exception ex) {
			System.out.println("getCorseList()예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return singleCorseList;
	}//getSingleCorseList-end
	
	//코스의 위도 경도 데이터를 불러온다
		public List<CorseDTO> getCorseLatLon(String corse_name){
			JSONArray array = new JSONArray();
			try {
				con = DBConnection.getInstacne().getConnection();
				pstmt = con.prepareStatement("SELECT * FROM corse where corse_name=?");
				pstmt.setString(1, corse_name);
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
			    	obj.put("corse_name", rs.getString("corse_name"));	// obj.put("key","value")
			    	obj.put("elev", rs.getDouble("elev"));
			        obj.put("lon", rs.getDouble("lon"));
			        obj.put("lat", rs.getDouble("lat"));
			        array.add(obj);	//작성한 JSON 객체를 배열에 추가
			    }
			}catch(Exception ex) {
				System.out.println("getCorseLatLon()예외:"+ex);
			}finally{
				try{
					if(stmt!=null){stmt.close();}
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				} catch (Exception exx) {}
			}//finally
			return array;
		}//getAllCorseList-end


//==============================================================================================
/*
 *  따릉이 정보 관련 DAO
 */
	public List<RentBikeInfoDTO> getRentBikeRecentInfo(){
		JSONArray array = new JSONArray();
		try {
			con = DBConnection.getInstacne().getConnection();
			pstmt = con.prepareStatement("select * from bike_real_time");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
		    	JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	obj.put("stationName", rs.getString("stationName"));	// obj.put("key","value")
		    	obj.put("rackToCnt", rs.getInt("rackToCnt"));	// obj.put("key","value")
		    	obj.put("bikeToCnt", rs.getInt("bikeToCnt"));	// obj.put("key","value")
		        obj.put("lon", rs.getDouble("lon"));
		        obj.put("lat", rs.getDouble("lat"));
		        obj.put("stationId", rs.getString("stationId"));	// obj.put("key","value")
		        obj.put("updatetime", rs.getTimestamp("updatetime").toLocalDateTime());
		        array.add(obj);	//작성한 JSON 객체를 배열에 추가
		    }
			
			
		}catch(Exception ex) {
			System.out.println("getRentBikeRecentInfo()예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return array;
	}
//==============================================================================================

}//CorseDAO-end