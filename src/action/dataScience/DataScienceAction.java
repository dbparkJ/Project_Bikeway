package action.dataScience;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import member.MemberDAO; // 조인
import member.MemberDTO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		RidingDTO dto=new RidingDTO();
		
		request.setAttribute("ridingdto",dto);
		
		return "/dataScience/dataScience.jsp";
	}

}
