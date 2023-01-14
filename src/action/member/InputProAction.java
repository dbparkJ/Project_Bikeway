package action.member;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.MemberDAO;
import member.MemberDTO;

public class InputProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		MemberDTO dto=new MemberDTO();
		
		//inputForm.jsp보내준 데이터를 dto에 담는다.		
		dto.setEmail(request.getParameter("email"));
		dto.setPassword(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setNickname(request.getParameter("nickname"));
		dto.setAddress(request.getParameter("address"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setWeight(Double.parseDouble(request.getParameter("weight")));	
		
	
		MemberDAO dao=MemberDAO.getDao();
		dao.insertMember(dto);//dao메서드 호출
		
		String email=request.getParameter("email");		
		request.setAttribute("email", email);
		
		System.out.println(email);
		System.out.println(Double.parseDouble(request.getParameter("weight")));
		
		return "/member/inputPro.jsp";
	}

}
