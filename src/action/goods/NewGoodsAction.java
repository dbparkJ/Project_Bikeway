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
		//리스트 담기위해서 리스트 생성
		List<NewGoodsDTO> goodslist = null; 
		
		//굿즈디에이오를 사용하려고 변수에 저장
		GoodsDAO goodsDAO = GoodsDAO.getDao();
		
		//리스트 변수 -> 굿즈디에이오 -> 신상품 담는로직을 담아줌
		goodslist = goodsDAO.newgoods();
		
		request.setAttribute("goodslist",goodslist);
		return "/goods/newgoods.jsp"; // 뷰리턴
	}

}
