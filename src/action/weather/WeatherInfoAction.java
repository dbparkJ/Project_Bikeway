package action.weather;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import java.sql.*;
import weather.*;
import java.util.*;

public class WeatherInfoAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	//System.out.println("Debug] requestPro 1");
	// 인코딩처리
	request.setCharacterEncoding("utf-8");

	// weatherRain
	System.out.println("rainDAO");
	WeatherRainDAO weatherRainDAO = WeatherRainDAO.getDao();
	List<WeatherRainDTO> rainvec = weatherRainDAO.rainInfo();
	
	// weatherTemp
	WeatherTempDAO weatherTempDAO = WeatherTempDAO.getDao();
	Vector<WeatherTempDTO> tempvec = weatherTempDAO.tempInfo();
	
	// System.out.println("weatherInfoAction"); 안찍힘
	
	// jsp 사용 할 값 설정
	request.setAttribute("rainvec",rainvec);
	request.setAttribute("tempvec",tempvec);
	
	return "/weather/weatherInfo.jsp";

	}
}
