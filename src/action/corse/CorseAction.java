package action.corse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import corse.CorseDAO;
import corse.CorseDTO;

public class CorseAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<CorseDTO> allCorseList = null;
		CorseDAO corseDAO = CorseDAO.getDao();
		
		allCorseList=corseDAO.getAllCorseList();
		
//		System.out.println(allCorseList.size());
		request.setAttribute("allCorseList", allCorseList);
		
		return "/corse/corse.jsp";
	}

}
