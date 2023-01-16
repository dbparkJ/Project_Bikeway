package action.dataScience;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bike.BikeDAO;
import bike.CorseDTO;
import command.CommandAction;
import member.LoginMemberDTO;
import member.MemberDAO;
import member.MemberDTO;
import riding.RidingDAO;
import riding.RidingDTO;

public class DataScienceAction implements CommandAction{

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		LoginMemberDTO loginMember = (LoginMemberDTO)session.getAttribute("member");
		
		MemberDAO memberDao=MemberDAO.getDao();	      
		MemberDTO memberDto = memberDao.getMember(loginMember.getEmail());      
		request.setAttribute("dto", memberDto);
		
		RidingDTO ridingDto= new RidingDTO();
		RidingDAO ridingDao= RidingDAO.getDao();
		ridingDto.setDistance(Double.parseDouble(request.getParameter("distance")));
		ridingDto.setRiding_time(Integer.parseInt(request.getParameter("riding_time")));
		ridingDto.setRiding_dt(LocalDate.parse(request.getParameter("riding_dt"),DateTimeFormatter.ISO_LOCAL_DATE));
		ridingDao.insertList(loginMember.getEmail(),ridingDto);
		
		// 주행거리
		List<RidingDTO> ridingmylist = null;
		List<RidingDTO> ridingAvglist = null;
		List<RidingDTO> ridingRankinglist = null;
		// 칼로리
		List<RidingDTO> caloriemylist = null;
		
		RidingDAO dao = RidingDAO.getDao();
		
		String riding_dt = request.getParameter("riding_dt");

		// 주행거리
		ridingmylist =dao.getRidingList(loginMember.getEmail(), riding_dt); // 나의 주행거리
		ridingAvglist = dao.getAvgRidingList(riding_dt); // 평균 주행거리
		ridingRankinglist = dao.getRankingList(riding_dt); // 상위 10%
		
		// 칼로리
		caloriemylist = dao.getKcalList(loginMember.getEmail(),riding_dt);

		// 주행거리
		request.setAttribute("ridingmylist", ridingmylist);
		request.setAttribute("ridingAvglist", ridingAvglist);
		request.setAttribute("ridingRankinglist", ridingRankinglist);
		
		// 칼로리
		request.setAttribute("caloriemylist",caloriemylist);
		
		return "/dataScience/dataScience.jsp";
	}

}