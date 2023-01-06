package action.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;


public class MainAction implements CommandAction {
	
	@Override 
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum=request.getParameter("pageNum");//view단에서 페이지 넘길때 요청 받는다
		
		if(pageNum==null){
	         pageNum="1";
	      }
		int currentPage=Integer.parseInt(pageNum);
		int pageSize=12;
		
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=currentPage*pageSize;
		
		int count=0;
		int number=0;
		int pageBlock=5;
		
	      return "/main/main.jsp"; //view return
	}
}
