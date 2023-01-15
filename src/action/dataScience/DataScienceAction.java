package action.dataScience;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
//		request.setAttribute(null, response);
//		
//		RidingDTO dto=new RidingDTO();
//		
//		dto.setDistance(Double.parseDouble(request.getParameter("distance")));
//		dto.setRiding_time(Integer.parseInt(request.getParameter("riding_time")));
//		dto.setRiding_dt(LocalDate.parse(request.getParameter("riding_dt"),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//			
//		
//		RidingDAO dao= RidingDAO.getDao();
//		dao.insertList(dto);
		RidingDTO dto = new RidingDTO();
		RidingDAO dao = RidingDAO.getDao();
		
		List<RidingDTO> list = null;
		
		String riding_time = request.getParameter("riding_time");
		System.out.println(request.getParameter("riding_time"));
		
		dao.getAvgRidingList(riding_time);
		
		
		return "/dataScience/dataScience.jsp";
	}

}