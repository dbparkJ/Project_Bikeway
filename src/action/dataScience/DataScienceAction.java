package action.dataScience;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		List list=null;
		
		RidingDTO ridingDTO=new RidingDTO();
		RidingDAO ridingDAO = RidingDAO.getDao();
		
		list = ridingDAO.getRidingList();
		
		request.setAttribute("list",list);
		request.setAttribute("ridingDTO",ridingDTO);
		
		return "/dataScience/dataScience.jsp";
	}

}
