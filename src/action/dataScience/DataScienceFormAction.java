package action.dataScience;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		return "/dataScience/dataScienceForm.jsp";
	}

}
