package action.dataScience;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//System.out.println("안녕");
		request.setCharacterEncoding("utf-8");
			
		RidingDTO dto=new RidingDTO();
		RidingDAO dao= RidingDAO.getDao();
		

		double distance = Integer.parseInt(request.getParameter("distance"));
		int riding_time = Integer.parseInt(request.getParameter("riding_time"));

		//System.out.println(floatToString);
		//System.out.println(riding_time);
		
		dto.setDistance(distance);
		dto.setRiding_time(riding_time);
	
		dao.insertList(dto);  //dao메서드 호출		
		
		return "/dataScience/dataScience.jsp";
	}

}