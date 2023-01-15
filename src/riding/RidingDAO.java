package riding;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import db.DBConnection;
import goods.NewGoodsDTO;
import member.LoginMemberDTO;
import riding.RidingDTO;

public class RidingDAO {
	// 싱글톤 객체사용
	private static RidingDAO instance = new RidingDAO();
	
	// 생성자
	private RidingDAO(){}
	
	public static RidingDAO getDao(){
		return instance;
	} // getDao-end
	
	//전역변수
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	//==========================
	// 주행거리, 주행시간 , 날짜 입력
	//==========================
	public void insertList(RidingDTO dto){
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("insert into riding(id,distance,calorie,riding_time,riding_dt) "
					+ "values(NULL,?,NULL,?,?)");

	//		pstmt.setInt(1, dto.getId());
			pstmt.setDouble(1, dto.getDistance());
			pstmt.setInt(2, dto.getRiding_time());
			pstmt.setDate(3, java.sql.Date.valueOf(dto.getRiding_dt()));
			//pstmt.setTimestamp(4,Timestamp.valueOf(riding_dt.getLocalDate()));

			rs=pstmt.executeQuery();
			
			
			//?값 채우기
			
		}catch(Exception ex){
			System.out.println("insertList()예외 : "+ex);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex){}
		}//finally-end
	}//insertMember()-end
	
	
	
	// ================
	// 내 기록 리스트화
	// =================	
	public List<RidingDTO> getRidingList()
	{
		LocalDate now = LocalDate.now();
		String format_not=now.toString();
	    return getRidingList(format_not);
	}//인자에 날짜가 안들어오면 일단 이번주의 값을 보여줌
	
	public List<RidingDTO> getRidingList(int riding_time){
		JSONArray myRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select b.riding_dt, nvl(a.distance, 0) from"
					+ "(select * from riding where id = 1) a "
					+ "right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance\r\n"
					+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT  -- 시작 일자\r\n"
					+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT -- 종료일자\r\n"
					+ "           FROM DUAL)\r\n"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt;");
			
			//pstmt.setInt(1, mem_id);
			pstmt.setInt(2, riding_time);
			pstmt.setInt(3, riding_time);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	//obj.put("id", rs.getInt("id"));	// obj.put("key","value")
		        obj.put("distance", rs.getDouble("distance"));
		        
		        myRidingArray.add(obj);	//작성한 JSON 객체를 배열에 추가
		    }
		}catch(Exception ex) {
			System.out.println("getRidingList()예외:"+ex);
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return myRidingArray;
	}//getRidingList()-end
	
	
	
		// ================
		// 평균 리스트화
		// =================		
		public List<RidingDTO> getAvgRidingList()
		{
			LocalDate now = LocalDate.now();
			String format_not=now.toString();
		    return getAvgRidingList(format_not);
		}//인자에 날짜가 안들어오면 일단 이번주의 값을 보여줌
		
		public List<RidingDTO> getAvgRidingList(String riding_time){
			JSONArray avgRidingArray = new JSONArray();
			try{
				con = DBConnection.getInstacne().getConnection();
				
				pstmt=con.prepareStatement("select b.riding_dt, nvl(a.distance, 0) from"
						+ "(select * from riding where id = ?) a "
						+ "right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance\r\n"
						+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT  -- 시작 일자\r\n"
						+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT -- 종료일자\r\n"
						+ "           FROM DUAL)\r\n"
						+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt;");
				
				pstmt.setString(1, riding_time);
				pstmt.setString(2, riding_time);
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
			    	obj.put("id", rs.getInt("id"));	// obj.put("key","value")
			        obj.put("distance", rs.getDouble("distance"));
			        
			        avgRidingArray.add(obj);	//작성한 JSON 객체를 배열에 추가
			    }
			}catch(Exception ex) {
				System.out.println("getRidingList()예외:"+ex);
			}finally{
				try{
					if(stmt!=null){stmt.close();}
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				} catch (Exception exx) {}
			}//finally
			return avgRidingArray;
		}//getRidingList()-end
}


