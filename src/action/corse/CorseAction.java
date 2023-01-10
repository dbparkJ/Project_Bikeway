package action.corse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bike.CorseDAO;
import bike.CorseDTO;
import command.CommandAction;

public class CorseAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<CorseDTO> singleCorseList = null;
		CorseDAO corseDAO = CorseDAO.getDao();
		
		singleCorseList=corseDAO.getSingleCorseList();
		
		request.setAttribute("singleCorseList", singleCorseList);
		return "/corse/corse.jsp";
	}

}
