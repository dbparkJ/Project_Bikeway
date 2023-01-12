package action.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import goods.*;

public class UsedGoodsAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		// 인코딩처리
		request.setCharacterEncoding("utf-8");
				
		GoodsDAO goodsDAO = GoodsDAO.getDao();
		List<UsedGoodsDTO> usedlist = goodsDAO.usedgoods();
				
		// jsp 사용 할 값 설정
		request.setAttribute("usedlist",usedlist);
		
		return "/goods/usedgoods.jsp";
	}

}
