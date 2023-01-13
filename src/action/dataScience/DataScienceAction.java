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
		
		RidingDTO dto=new RidingDTO();
		RidingDAO dao= RidingDAO.getDao();
		

		Double distance = Double.parseDouble(request.getParameter("distance"));
		Integer riding_time = Integer.parseInt(request.getParameter("riding_time"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		//LocalDate riding_dt = LocalDate.parse(request.getParameter("riding_dt"),DateTimeFormatter.ISO_DATE);
		LocalDate riding_dt = LocalDate.parse(request.getParameter("riding_dt"),DateTimeFormatter.ofPattern("yyyy/MM/dd"));

		dao.insertList(id,distance,riding_time,riding_dt); //dao 메서드 호출		

		
		return "/dataScience/dataScience.jsp";
	}

}