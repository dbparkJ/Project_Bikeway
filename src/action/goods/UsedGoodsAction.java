package action.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

import goods.*;

public class UsedGoodsAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		GoodsDAO goodsDAO = GoodsDAO.getDao();
		List<UsedGoodsDTO> usedlist = goodsDAO.usedgoods();
		request.setAttribute("usedlist",usedlist);

		return "/goods/usedgoods.jsp";
	}

}
