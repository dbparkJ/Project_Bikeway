package riding;
import java.sql.*;

import java.time.LocalDateTime;

import java.util.ArrayList;
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
	
	//==================
	// 총 주행거리
	//==================
	public RidingDTO week_distance(int id){
		RidingDTO dto = null;
		
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("select sum(distance) from riding where id=?");
			
			pstmt.setInt(1,id);
			
			rs=pstmt.executeQuery();
			
			//rs 내용을 dto에 넣고
			//dto를 리턴
			if(rs.next()){
				dto=new RidingDTO(); //객체생성
				
				dto.setId(rs.getInt("id"));
				dto.setDistance(rs.getFloat("distance"));
				dto.setCalorie(rs.getFloat("calorie"));
				dto.setRiding_time(rs.getFloat("riding_time"));
			
				//dto.setRiding_dt(rs.getTimestamp("riding_dt"));
				
			}//if-end
			
		}catch(Exception ex){
			System.out.println("week_distance 예외 : "+ex);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){}
		}//finally-end
		
		return dto;
	} // week_distance-end
	
	//==========================
	// 주행거리, 주행시간 , 날짜 입력
	//==========================
	public void insertList(RidingDTO dto){
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("insert into riding values(0,?,null,?,NOW())");
			
			rs=pstmt.executeQuery();
			
			//?값 채우기
			pstmt.setFloat(1,dto.getDistance());
			pstmt.setFloat(2,dto.getRiding_time());
		//pstmt.(3,dto.getRiding_dt().toLocalDate());
			
			pstmt.executeUpdate(); //쿼리 수행
			
		}catch(Exception ex){
			System.out.println("insertMember()예외 : "+ex);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception exx){}
		}//finally-end
	}//insertMember()-end
}
