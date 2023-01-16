package action.dataScience;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import command.CommandAction;
import member.*;

public class DataScienceFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession();
	      
		LoginMemberDTO loginMember = (LoginMemberDTO)session.getAttribute("member");
		  
		MemberDAO memberDao=MemberDAO.getDao();	      
		MemberDTO memberDto = memberDao.getMember(loginMember.getEmail());      
		request.setAttribute("dto", memberDto);
		
		return "/dataScience/dataScienceForm.jsp";
	}

}
