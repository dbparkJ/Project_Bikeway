package action.total;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bike.BikeDAO; // bike정보
import bike.CorseDTO; // corse정보
import weather.*; // weather정보
import command.CommandAction;

public class TotalAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// corse
		List<CorseDTO> CorseList = null;
		BikeDAO corseDAO = BikeDAO.getDao();
		
		CorseList=corseDAO.getCorseList();
		
		// weather
		// weatherRain
		WeatherDAO weatherRainDAO = WeatherDAO.getDao();
		List<WeatherRainDTO> rainlist = weatherRainDAO.rainInfo();
		
		// weatherTemp
		WeatherDAO weatherTempDAO = WeatherDAO.getDao();
		Vector<WeatherTempDTO> tempvec = weatherTempDAO.tempInfo();
				
		// jsp 사용 할 값 설정
		// weather
		request.setAttribute("rainlist",rainlist);
		request.setAttribute("tempvec",tempvec);
		
		// corse
		request.setAttribute("singleCorseList", CorseList);
		
		return "/total/total.jsp";
	}

}
