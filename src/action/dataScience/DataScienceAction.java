package action.dataScience;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bike.BikeDAO;
import bike.CorseDTO;
import command.CommandAction;

import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		List<RidingDTO> ridingmylist = null;
		List<RidingDTO> ridingAvglist = null;
		List<RidingDTO> ridingRankinglist = null;
		List<RidingDTO> kcalmylist = null;
		
		RidingDAO dao = RidingDAO.getDao();
		
		String riding_dt = request.getParameter("riding_dt");
		
		// 주행거리
		ridingmylist =dao.getRidingList(riding_dt); // 나의 주행거리
		ridingAvglist = dao.getAvgRidingList(riding_dt); // 평균 주행거리
		ridingRankinglist = dao.getRankingList(riding_dt); // 상위 10%
		
		// 칼로리
		kcalmylist = dao.getKcalList(riding_dt);
		
		//System.out.println(kcalmylist);
		
		// 주행거리
		request.setAttribute("ridingmylist", ridingmylist);
		request.setAttribute("ridingAvglist", ridingAvglist);
		request.setAttribute("ridingRankinglist", ridingRankinglist);
		
		// 칼로리
		request.setAttribute("kcalmylist", kcalmylist);
	
		return "/dataScience/dataScience.jsp";
	}

}