package bike;

import java.net.http.HttpRequest;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import db.DBConnection;
import weather.WeatherRainDTO;

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

				pstmt = con.prepareStatement("SELECT * FROM corse where corse_name=? order by seq");

				pstmt.setString(1, corse_name);
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
			    	obj.put("corse_name", rs.getString("corse_name"));	// obj.put("key","value")
			        obj.put("lon", rs.getDouble("lon"));
			        obj.put("lat", rs.getDouble("lat"));
			        obj.put("elev", rs.getDouble("elev"));
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

		
		//코스위경도 최대값, 최소값, 평균값 가져오기
		public List<Corse_MAX_MIN_DTO> getCorse_max_minLatLon(String corse_name){
			JSONArray array = new JSONArray();
			try {
				con = DBConnection.getInstacne().getConnection();
				pstmt = con.prepareStatement("SELECT  MAX(LON) LON_MAX, MAX(LAT) LAT_MAX,\r\n"
						+ "        MIN(LON) LON_MIN, MIN(LAT) LAT_MIN,\r\n"
						+ "        AVG(LON) LON_AVG, AVG(LAT) LAT_AVG\r\n"
						+ "  FROM CORSE\r\n"
						+ "WHERE CORSE_NAME =? GROUP BY CORSE_NAME");
				pstmt.setString(1, corse_name);
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
			    	obj.put("LON_MAX", rs.getDouble("LON_MAX"));	// obj.put("key","value")
			        obj.put("LAT_MAX", rs.getDouble("LAT_MAX"));
			        obj.put("LON_MIN", rs.getDouble("LON_MIN"));
			        obj.put("LAT_MIN", rs.getDouble("LAT_MIN"));
			        obj.put("LON_AVG", rs.getDouble("LON_AVG"));
			        obj.put("LAT_AVG", rs.getDouble("LAT_AVG"));			        
			        array.add(obj);	//작성한 JSON 객체를 배열에 추가
			    }
			}catch(Exception ex) {
				System.out.println("getCorse_max_minLatLon()예외:"+ex);
			}finally{
				try{
					if(stmt!=null){stmt.close();}
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				} catch (Exception exx) {}
			}//finally
			return array;
		}//getCorse_max_minLatLon-end				
		
		//id별 주행거리 주행시간 몸무게 주행일자 가져오기 
		public List<Id_Dis_Rid_Wei_DTO> getCorse_id_ds_rid_wid(String id, Date riding_dt ){
			JSONArray array = new JSONArray();
			try {
				con = DBConnection.getInstacne().getConnection();
				pstmt = con.prepareStatement("SELECT A.DISTANCE,A.RIDING_TIME,B.WEIGHT,A.RIDING_DT   \r\n"
						+ "  FROM RIDING A,MEMBER B\r\n"
						+ "WHERE A.ID = B.ID\r\n"
						+ "  AND A.ID = ?\r\n"
						+ "  AND A.RIDING_DT = ?");
				pstmt.setString(1, id);
				pstmt.setDate(2, riding_dt);				
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
			    	obj.put("DISTANCE", rs.getDouble("DISTANCE"));	// obj.put("key","value")
			        obj.put("RIDING_TIME", rs.getDouble("RIDING_TIME"));
			        obj.put("WEIGHT", rs.getDouble("WEIGHT"));
			        obj.put("RIDING_DT", rs.getDate("RIDING_DT"));					        
			        array.add(obj);	//작성한 JSON 객체를 배열에 추가
			    }
			}catch(Exception ex) {
				System.out.println("getCorse_id_ds_rid_wid()예외:"+ex);
			}finally{
				try{
					if(stmt!=null){stmt.close();}
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				} catch (Exception exx) {}
			}//finally
			return array;
		}//getCorse_id_ds_rid_wid-end		
		
//==============================================================================================
/*
*  따릉이 정보 관련 DAO
*/
//==============================================================================================		
		public List<RentBikeInfoDTO> getRentBikeRecentInfo(){
			JSONArray rentbikeList = new JSONArray();
			try {
				con = DBConnection.getInstacne().getConnection();
				pstmt = con.prepareStatement("select * from bike_real_time where updatetime = (select max(updatetime) from bike_real_time)");
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject latlon = new JSONObject();	// {}, JSON 객체 생성
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
					latlon.put("lon", rs.getDouble("lon"));
					latlon.put("lat", rs.getDouble("lat"));
					obj.put("stationId", rs.getString("stationId"));	// obj.put("key","value")
					obj.put("stationName", rs.getString("stationName"));	// obj.put("key","value")
			    	obj.put("rackToCnt", rs.getInt("rackToCnt"));	// obj.put("key","value")
			    	obj.put("bikeToCnt", rs.getInt("bikeToCnt"));	// obj.put("key","value")
			    	obj.put("latlonList", latlon);	// obj.put("key","value")
			        rentbikeList.add(obj);	//작성한 JSON 객체를 배열에 추가
				}
			}catch(Exception ex) {
				System.out.println("getRentBikeRecentInfo()예외:"+ex);
			}finally{
				try{
					if(stmt!=null){stmt.close();}
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				} catch (Exception exx) {}
			}//finally
			return rentbikeList;
		}//getRentBikeRecentInfo-end
//==============================================================================================		
		public List<MatzipDTO> getMatzipList(Double lat, Double lon){
			JSONArray matZipList = new JSONArray();
			try {
				con = DBConnection.getInstacne().getConnection();
				pstmt = con.prepareStatement(" select * from(select name, category, subcategory, review,"
						+ "abs(lon-?) as lon,abs(lat-?)as lat "
						+ "from matzip order by lon) where rownum <=50");
				
				pstmt.setDouble(1, lon);
				pstmt.setDouble(2, lat);
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
					obj.put("name", rs.getString("name"));	// obj.put("key","value")
					obj.put("category", rs.getString("category"));	// obj.put("key","value")
			    	obj.put("subcategory", rs.getString("subcategory"));	// obj.put("key","value")
			    	obj.put("review", rs.getDouble("review"));	// obj.put("key","value")
			    	obj.put("lon", rs.getDouble("lon"));	// obj.put("key","value")
			    	obj.put("lat", rs.getDouble("lat"));	// obj.put("key","value")
			    	matZipList.add(obj);	//작성한 JSON 객체를 배열에 추가
				}
			}catch(Exception ex) {
				System.out.println("getMatzipList()예외:"+ex);
			}finally{
				try{
					if(stmt!=null){stmt.close();}
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				} catch (Exception exx) {}
			}//finally
			return matZipList;
		}//getRentBikeRecentInfo-end



}//CorseDAO-end