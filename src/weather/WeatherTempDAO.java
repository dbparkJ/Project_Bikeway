package weather;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import db.DBConnection;
import weather.*;

// 기온 info.
public class WeatherTempDAO {
	
	// 싱글톤 객체사용
	private static WeatherTempDAO instance = new WeatherTempDAO();
			
	// 생성자
	private WeatherTempDAO(){}
			
	public static WeatherTempDAO getDao(){
			return instance;
	}//getDao-end
	
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	// ================
	// 주간 전체 기온 조회.
	// =================
	public Vector<WeatherTempDTO> tempInfo(){
		Vector<WeatherTempDTO> vec=new Vector<WeatherTempDTO>();//객체생성
		try{
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select * from weather_temp where updatetime = (select max(updatetime) from weather_temp)");
			rs=pstmt.executeQuery();
			
			// rs 내용을 DTO에 넣고 DTO 를 리턴해준다.
			
			WeatherTempDTO dto=null;
			
			while(rs.next()){
				dto=new WeatherTempDTO();
				
				dto.setAreaname(rs.getString("areaname"));
				
				dto.setLowtemp_1(rs.getInt("lowtemp_1"));
				dto.setHightemp_1(rs.getInt("hightemp_1"));
				
				dto.setLowtemp_2(rs.getInt("lowtemp_2"));
				dto.setHightemp_2(rs.getInt("hightemp_2"));
				
				dto.setLowtemp_3(rs.getInt("lowtemp_3"));
				dto.setHightemp_3(rs.getInt("hightemp_3"));
				
				dto.setLowtemp_4(rs.getInt("lowtemp_4"));
				dto.setHightemp_4(rs.getInt("hightemp_4"));
				
				dto.setLowtemp_5(rs.getInt("lowtemp_5"));
				dto.setHightemp_5(rs.getInt("hightemp_5"));
				
				dto.setUpdatetime(rs.getTimestamp("updatetime"));
				
				vec.add(dto);
			} // while-end
		}catch(Exception ex){
			System.out.println("rainInfo : "+ex);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(con!=null){
					con.close();
				}
			}catch(Exception ex2){}
		}//finally-end
		
		return vec;
	}//getMember-end

}
