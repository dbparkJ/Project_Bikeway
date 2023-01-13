package riding;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DBConnection;

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
	public void insertList(Integer id, Double distance, Integer riding_time, LocalDate riding_dt){
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("insert into riding(id,distance,calorie,riding_time,riding_dt) "
					+ "values(?,?,NULL,?,?)");
			
			rs=pstmt.executeQuery();
			
			//?값 채우기
			pstmt.setInt(1,id);
			pstmt.setDouble(2,distance);
			pstmt.setInt(3,riding_time);
			//pstmt.setTimestamp(4,Timestamp.valueOf(riding_dt.getLocalDate()));
			pstmt.setDate(3,java.sql.Date.valueOf(riding_dt));
			
			pstmt.executeUpdate(); //쿼리 수행
			
		}catch(Exception ex){
			System.out.println("insertList()예외 : "+ex);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex){}
		}//finally-end
	}//insertMember()-end
}
