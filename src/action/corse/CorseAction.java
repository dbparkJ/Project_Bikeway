package action.corse;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bike.BikeDAO;
import bike.CorseDTO;
import command.CommandAction;

public class CorseAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<CorseDTO> CorseList = null;
		BikeDAO corseDAO = BikeDAO.getDao();
		
		CorseList=corseDAO.getCorseList();
		
		request.setAttribute("singleCorseList", CorseList);
		return "/corse/corse.jsp";
	}

}
