package action.dataScience;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//request.setCharacterEncoding("utf-8");
		//System.out.println("데이터사이언스액션"); <= 얘 찍힘
		RidingDTO dto=new RidingDTO();
		RidingDAO dao= RidingDAO.getDao();
		
		System.out.println("데이터사이언스액션");
		double distance = Integer.parseInt(request.getParameter("distance"));
		int riding_time = Integer.parseInt(request.getParameter("riding_time"));

		//System.out.println("데이터사이언스액션"); <= 얘 안찍힘
		
		dto.setDistance(distance);
		dto.setRiding_time(riding_time);
		
		System.out.println(dto);
		dao.insertList(dto);  //dao메서드 호출		
		
		return "/dataScience/dataScience.jsp";
	}

}