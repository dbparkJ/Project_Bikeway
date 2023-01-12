package weather;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import db.DBConnection;
import weather.*;

// 강수 info.
public class WeatherRainDAO {	
	// 싱글톤 객체사용
	private static WeatherRainDAO instance = new WeatherRainDAO();
		
		// 생성자
		private WeatherRainDAO(){}
		
		public static WeatherRainDAO getDao(){
			return instance;
	}//getDao-end
	
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
	// ================
	// 주간 전체 강수 조회.
	// =================
	public List<WeatherRainDTO> rainInfo(){
		List<WeatherRainDTO> list = null;
		try{
			System.out.println("Debug] rainInfo 함수 1");
			con = DBConnection.getInstacne().getConnection();
			
			pstmt=con.prepareStatement("select * from weather_rain where updatetime = (select max(updatetime) from weather_rain)");
			rs=pstmt.executeQuery();
			
			
			if(rs.next()){
				list = new ArrayList<WeatherRainDTO>();
				
				//dto=new WeatherRainDTO();
				do {
				WeatherRainDTO dto = new WeatherRainDTO();
				
				dto.setAreaname(rs.getString("areaname"));
				
				dto.setRain_1_am(rs.getInt("rain_1_am"));
				dto.setWeather_1_am(rs.getString("weather_1_am"));
				dto.setRain_1_pm(rs.getInt("rain_1_pm"));
				dto.setWeather_1_pm(rs.getString("weather_1_pm"));
				
				dto.setRain_2_am(rs.getInt("rain_2_am"));
				dto.setWeather_2_am(rs.getString("weather_2_am"));
				dto.setRain_2_pm(rs.getInt("rain_2_pm"));
				dto.setWeather_2_pm(rs.getString("weather_2_pm"));
				
				dto.setRain_3_am(rs.getInt("rain_3_am"));
				dto.setWeather_3_am(rs.getString("weather_3_am"));
				dto.setRain_3_pm(rs.getInt("rain_3_pm"));
				dto.setWeather_3_pm(rs.getString("weather_3_pm"));
				
				dto.setRain_4_am(rs.getInt("rain_4_am"));
				dto.setWeather_4_am(rs.getString("weather_4_am"));
				dto.setRain_4_pm(rs.getInt("rain_4_pm"));
				dto.setWeather_4_pm(rs.getString("weather_4_pm"));
				
				dto.setRain_5_am(rs.getInt("rain_5_am"));
				dto.setWeather_5_am(rs.getString("weather_5_am"));
				dto.setRain_5_pm(rs.getInt("rain_5_pm"));
				dto.setWeather_5_pm(rs.getString("weather_5_pm"));
				
				dto.setUpdatetime(rs.getTimestamp("updatetime"));
				
				list.add(dto);
			}while (rs.next());
		} 
		}catch(Exception ex){
			System.out.println("rainInfo 예외 : "+ex);
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
		
		return list;
	}//rainInfo()-end
}
