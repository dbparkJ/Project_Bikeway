package action.corse;

import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bike.BikeDAO;
import bike.CorseDTO;
import command.CommandAction;

public class ElevAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<CorseDTO> elevInfo = null;
		BikeDAO corseDAO = BikeDAO.getDao();
		
		elevInfo=corseDAO.getCorseElev();
		request.setAttribute("elevInfo", elevInfo);
		return "/corse/elev.jsp";
	}

}