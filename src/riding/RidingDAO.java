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
	
	//id 인자 , distance, riding_dt
	public List<RidingDTO> getRidingList(String email){
		List<RidingDTO> riding_list = null;
		try {
			con = DBConnection.getInstacne().getConnection();
			pstmt = con.prepareStatement("select distance, riding_dt from riding where email=?");
			pstmt.setString(1, email);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				riding_list=new ArrayList<RidingDTO>();
				do{	
					RidingDTO dto=new RidingDTO();
					dto.setDistance(rs.getDouble("distance"));
					dto.setRiding_dt(rs.getDate("riding_dt").toLocalDate());
					riding_list.add(dto); //***
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
		return riding_list;
	}//getRidingList-end
	
	//dataScience Action
	public List<RidingDTO> getRidingList(String email, String riding_dt){
		JSONArray myRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select b.riding_dt, nvl(a.distance, 0) as distance, a.id as id from"
					+ "(select * from riding where email = ?) a "
					+ "right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance"
					+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT"
					+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT"
					+ "           FROM DUAL)"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt");
			
			pstmt.setString(1, email);
			pstmt.setString(2, riding_dt);
			pstmt.setString(3, riding_dt);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	obj.put("id", rs.getInt("id"));	// obj.put("key","value")
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
	// 평균 리스트화
	// =================		
	public List<RidingDTO> getAvgRidingList()
	{
		LocalDate now = LocalDate.now();
		String format_not=now.toString();
		
		return getAvgRidingList(format_not);
	}//인자에 날짜가 안들어오면 일단 이번주의 값을 보여줌
		
	public List<RidingDTO> getAvgRidingList(String riding_dt){
		JSONArray avgRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select b.riding_dt, nvl(a.avg, 0) as distance from (select riding_dt,sum(distance) as d_sum,round(sum(distance)/(select count(distinct(id)) from riding),2) as avg"
					+ "                from riding group by riding_dt order by riding_dt) a right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance"
					+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT"
					+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT"
					+ "           FROM DUAL)"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt"
					+ "");
			
			pstmt.setString(1, riding_dt);
			pstmt.setString(2, riding_dt);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	//obj.put("id", rs.getInt("id"));	// obj.put("key","value")
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

//==============================================================================================
	//================
	// 상위10%
	// =================	
	public List<RidingDTO> getRankingList()
	{
		LocalDate now = LocalDate.now();
		String format_not=now.toString();
		
	    return getRidingList(format_not);
	}//인자에 날짜가 안들어오면 일단 이번주의 값을 보여줌
	
	public List<RidingDTO> getRankingList(String riding_dt){
		JSONArray rankingRidingArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select b.riding_dt, nvl(a.avg,0) distance from (select riding_dt,round(sum(distance)/(select ceil(count(distinct(id))*0.1) from riding),2) as avg from riding where id in (select id from"
					+ "    (select sum(distance) sum, id from riding"
					+ "    group by id order by sum desc)"
					+ "    where rownum<= (select ceil(count(distinct(id))*0.1) from riding)) group by riding_dt order by riding_dt) a right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance"
					+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT"
					+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT"
					+ "           FROM DUAL)"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt"
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
	// 내 칼로리 칼로리,날짜dtCALORIE
	// =================	
	public List<RidingDTO> getKcalList(String email, String riding_dt){
		List<RidingDTO> calorieList = null;
		try {
			con = DBConnection.getInstacne().getConnection();
			pstmt = con.prepareStatement("select b.riding_dt, nvl(a.cal, 0) calorie from(select  r.riding_dt riding_dt,2.3 * m.weight*(r.riding_time*0.0667) as cal from member m join riding r on m.email=r.email where m.email=?) a right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance\r\n"
					+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT  -- 시작 일자\r\n"
					+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT -- 종료일자\r\n"
					+ "           FROM DUAL)\r\n"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt");
			pstmt.setString(1, email);
			pstmt.setString(2, riding_dt);
			pstmt.setString(3, riding_dt);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				calorieList=new ArrayList<RidingDTO>();
				do{	
					RidingDTO dto=new RidingDTO();
					dto.setCalorie(rs.getDouble("calorie"));
					dto.setRiding_dt(rs.getDate("riding_dt").toLocalDate());
					calorieList.add(dto); //***
				}while(rs.next());
			}
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
		return calorieList;
	
	}//인자에 날짜가 안들어오면 일단 이번주의 값을 보여줌
	
	public List<RidingDTO> getKcalJson(String riding_dt){
		JSONArray myKcalArray = new JSONArray();
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select b.riding_dt, round(nvl(a.cal, 0),2) as calorie from(select  r.riding_dt riding_dt,2.3 * m.weight*(r.riding_time*0.0667) as cal from member m join riding r on m.id=r.id where m.id=1) a right join (SELECT TO_CHAR(SDT + LEVEL - 1, 'YYYY-MM-DD') riding_dt, 0 as distance"
					+ "   FROM (SELECT TO_DATE(?, 'YYYY-MM-DD') SDT"
					+ "              , (TO_DATE(?, 'YYYY-MM-DD')+6) EDT"
					+ "           FROM DUAL)"
					+ " CONNECT BY LEVEL <= EDT - SDT + 1) b on a.riding_dt = b.riding_dt order by b.riding_dt");
			
			//pstmt.setInt(1, mem_id);
			pstmt.setString(1, riding_dt);
			pstmt.setString(2, riding_dt);
			
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();	// {}, JSON 객체 생성
		    	//obj.put("id", rs.getInt("id"));	// obj.put("key","value")
		        obj.put("calorie", rs.getDouble("calorie"));
		        obj.put("riding_dt", rs.getString("riding_dt"));
		        
		        myKcalArray.add(obj);	//작성한 JSON 객체를 배열에 추가
		    }
		}catch(Exception ex) {
			System.out.println("myKcalArray()예외:"+ex);
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			} catch (Exception exx) {}
		}//finally
		return myKcalArray;
	}//myKcalArray()-end
}
	




