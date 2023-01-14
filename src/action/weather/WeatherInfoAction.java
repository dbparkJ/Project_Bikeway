package action.weather;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import java.sql.*;
import weather.*;
import java.util.*;

public class WeatherInfoAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	// 인코딩처리
	request.setCharacterEncoding("utf-8");

	// weatherRain
	WeatherDAO weatherRainDAO = WeatherDAO.getDao();
	List<WeatherRainDTO> rainlist = weatherRainDAO.rainInfo();
	
	// weatherTemp
	WeatherDAO weatherTempDAO = WeatherDAO.getDao();
	Vector<WeatherTempDTO> tempvec = weatherTempDAO.tempInfo();
	
	
	// jsp 사용 할 값 설정
	request.setAttribute("rainlist",rainlist);
	request.setAttribute("tempvec",tempvec);
	
	return "/weather/weatherInfo.jsp";

	}
}
