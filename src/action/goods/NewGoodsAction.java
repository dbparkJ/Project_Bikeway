package action.goods;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;

import bike.BikeDAO;
import bike.CorseDTO;
import command.CommandAction;
import java.sql.*;
import goods.*;
import java.util.*;

public class NewGoodsAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		List<NewGoodsDTO> goodslist = null; 
		GoodsDAO goodsDAO = GoodsDAO.getDao();
		goodslist= goodsDAO.newgoods();
		request.setAttribute("goodslist",goodslist);
		return "/goods/newgoods.jsp"; // 뷰리턴
	}

}
