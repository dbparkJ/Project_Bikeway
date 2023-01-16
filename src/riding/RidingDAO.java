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

import bike.CorseDTO;
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
	public void insertList(String email,RidingDTO dto){
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("insert into riding(email,distance,calorie,riding_time,riding_dt) "
					+ "values(?,?,NULL,?,?)");

			pstmt.setString(1, email);
			pstmt.setDouble(2, dto.getDistance());
			pstmt.setInt(3, dto.getRiding_time());
			pstmt.setDate(4, java.sql.Date.valueOf(dto.getRiding_dt()));
			rs=pstmt.executeQuery();
			
		}catch(Exception ex){
			System.out.println("insertList()예외 : "+ex);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex){}
		}//finally-end
	}//insertList()-end
	
	
	// ================
	// 주행거리 내 기록 리스트화
	// =================
	public List<RidingDTO> getRidingList(String email, String riding_dt){
		JSONArray myRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();

			pstmt=con.prepareStatement("select b.riding_dt, nvl(a.distance, 0) as distance, a.email as email from"
					+ "(select * from riding where email = ?) a "
					+ "right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance"
					+ "   FROM (SELECT trunc(TO_DATE(?, 'YYYY-MM-DD'),'day') SDT"
					+ "        , trunc((TO_DATE(?, 'YYYY-MM-DD')),'day')+6 EDT"
					+ "           FROM DUAL)"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt");
			
			pstmt.setString(1, email);
			pstmt.setString(2, riding_dt);
			pstmt.setString(3, riding_dt);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
				
		        obj.put("distance", rs.getDouble("distance"));
		        obj.put("riding_dt", rs.getString("riding_dt"));
		        
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
	// 평균 주행거리 분석
	// =================				
	public List<RidingDTO> getAvgRidingList(String riding_dt){
		JSONArray avgRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select b.riding_dt, nvl(a.avg, 0) as distance from (select riding_dt,sum(distance) as d_sum,round(sum(distance)/(select count(distinct(email)) from riding),2) as avg\r\n"
					+ "                           from riding group by riding_dt order by riding_dt) a right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance\r\n"
					+ "                 FROM (SELECT trunc(TO_DATE(?, 'YYYY-MM-DD'),'day') SDT\r\n"
					+ "                            , trunc((TO_DATE(?, 'YYYY-MM-DD')),'day')+6 EDT\r\n"
					+ "                          FROM DUAL)\r\n"
					+ "                CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt"
					+ "");
			
			pstmt.setString(1, riding_dt);
			pstmt.setString(2, riding_dt);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
				
		        obj.put("distance", rs.getDouble("distance"));
		        obj.put("riding_dt", rs.getString("riding_dt"));
		        
		        avgRidingArray.add(obj);	//작성한 JSON 객체를 배열에 추가
		    }
		}catch(Exception ex) {
			System.out.println("getAvgRidingList()예외:"+ex);
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return avgRidingArray;
	}// getAvgRidingList()-end

	//================
	// 주행거리 상위10%
	// =================	
	public List<RidingDTO> getRankingList(String riding_dt){
		JSONArray rankingRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement(" select riding_dt, round(avg(distance),2) distance from (select * from (select email, riding_dt, distance, rank() over(partition by riding_dt order by distance desc) rnk, count(email) over(partition by riding_dt) as cnt from riding) a where ((a.rnk/a.cnt) <= 0.1) or (cnt<10)) group by riding_dt \r\n"
					+ " having riding_dt in (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt\r\n"
					+ "   FROM (SELECT trunc(TO_DATE(?, 'YYYY-MM-DD'),'day') SDT "
					+ "              , trunc((TO_DATE(?, 'YYYY-MM-DD')),'day')+6 EDT "
					+ "           FROM DUAL)\r\n"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1)"
					+ "");
			
			pstmt.setString(1, riding_dt);
			pstmt.setString(2, riding_dt);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	//obj.put("id", rs.getInt("id"));	// obj.put("key","value")
		        obj.put("distance", rs.getDouble("distance"));
		        obj.put("riding_dt", rs.getString("riding_dt"));
		        
		        rankingRidingArray.add(obj);	//작성한 JSON 객체를 배열에 추가
		    }
		}catch(Exception ex) {
			System.out.println("getRankingList()예외:"+ex);
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return rankingRidingArray;
	}

//=============================================================================
	
	//================
	// 내 칼로리데이터
	// =================	
	public List<RidingDTO> getKcalList(String email, String riding_dt){
		List<RidingDTO> caloriemyList = null;
		try {
			con = DBConnection.getInstacne().getConnection();
			pstmt = con.prepareStatement("select b.riding_dt, nvl(a.cal, 0) calorie \r\n"
					+ "from(select  r.riding_dt riding_dt,2.3 * m.weight*(r.riding_time*0.0667) as cal \r\n"
					+ "from member m join riding r on m.email=r.email where m.email=?) a \r\n"
					+ "right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance\r\n"
					+ "                FROM (SELECT trunc(TO_DATE(?, 'YYYY-MM-DD'),'day') SDT\r\n"
					+ "                ,trunc((TO_DATE(?, 'YYYY-MM-DD')),'day')+6 EDT\r\n"
					+ "                FROM DUAL)\r\n"
					+ "                CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt");
			
			pstmt.setString(1, email);
			pstmt.setString(2, riding_dt);
			pstmt.setString(3, riding_dt);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				caloriemyList = new ArrayList<RidingDTO>();
				do{	
					RidingDTO dto=new RidingDTO();
					
					dto.setCalorie(rs.getDouble("calorie"));
					dto.setRiding_dt(rs.getDate("riding_dt").toLocalDate());
					
					caloriemyList.add(dto); //***
				}while(rs.next());
			}
		}catch(Exception ex) {
			System.out.println("getKcalList()예외:"+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return caloriemyList;
	
	} // getKcalList()-end
	
	
}
	




