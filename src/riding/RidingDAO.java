package riding;
import java.sql.*;

import db.DBConnection;
import member.LoginMemberDTO;

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
	// 일주일 주행거리
	//==================
	public RidingDTO week_distance(Integer id){
		RidingDTO dto = null;
		
		try{
			con = DBConnection.getInstacne().getConnection();
			pstmt=con.prepareStatement("select sum(distance) from riding where id = ?");
			
			pstmt.setInt(1,id);
			
			rs=pstmt.executeQuery();
			
			//rs 내용을 dto에 넣고
			//dto를 리턴
			if(rs.next()){
				dto=new RidingDTO(); //객체생성
				
				dto.setId(rs.getInt("id"));
				dto.setDistance(rs.getInt("distance"));
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
}
