package action.goods;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import java.sql.*;
import goods.*;
import java.util.*;

public class NewGoodsAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		// 인코딩처리
		request.setCharacterEncoding("utf-8");
		
		GoodsDAO goodsDAO = GoodsDAO.getDao();
		List<NewGoodsDTO> newlist = goodsDAO.newgoods();
		
		// jsp 사용 할 값 설정
		request.setAttribute("newlist",newlist);
		
		return "/goods/newgoods.jsp"; // 뷰리턴
	}

}
