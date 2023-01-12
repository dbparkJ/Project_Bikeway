package goods;

import java.sql.*;
import java.util.*; // list

import db.DBConnection;
import goods.*;
import weather.WeatherRainDAO;
import weather.WeatherRainDTO;

public class GoodsDAO {
	// 싱글톤 객체사용
	private static GoodsDAO instance = new GoodsDAO();
		
		// 생성자
		private GoodsDAO(){}
		
		public static GoodsDAO getDao(){
			return instance;
	}//getDao-end
	
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	
		// ================
		// 새상품 리스트화
		// =================
		public List<NewGoodsDTO> newgoods(){
			List<NewGoodsDTO> list = null;
			try{
				con = DBConnection.getInstacne().getConnection();
				
				pstmt=con.prepareStatement("select * from new_goods");
				rs=pstmt.executeQuery();
				
				
				if(rs.next()){
					list = new ArrayList<NewGoodsDTO>();
					
					do {
					NewGoodsDTO dto = new NewGoodsDTO();
					
					dto.setName(rs.getString("name"));
					
					dto.setImg(rs.getString("img"));
					dto.setLink(rs.getString("link"));
					dto.setPrice(rs.getInt("price"));
					
					list.add(dto);
				}while (rs.next());
			} 
			}catch(Exception ex){
				System.out.println("newgoods 예외 : "+ex);
			}finally{
				try{
					if(rs!=null){
						rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					if(con!=null){
						con.close();
					}
				}catch(Exception ex2){}
			}//finally-end
			
			return list;
		}//newgoods()-end
		
		// ================
		// 중고상품 리스트화
		// =================
		public List<UsedGoodsDTO> usedgoods(){
			List<UsedGoodsDTO> list = null;
			try{
				con = DBConnection.getInstacne().getConnection();
				
				pstmt=con.prepareStatement("select * from used_goods");
				rs=pstmt.executeQuery();
				
				
				if(rs.next()){
					list = new ArrayList<UsedGoodsDTO>();
					
					do {
					UsedGoodsDTO dto = new UsedGoodsDTO();
					
					dto.setTitle(rs.getString("title"));
					
					dto.setImg(rs.getString("img"));
					dto.setLink(rs.getString("link"));
					dto.setSite(rs.getString("site"));
					
					dto.setPrice(rs.getInt("price"));
					
					list.add(dto);
				}while (rs.next());
			} 
			}catch(Exception ex){
				System.out.println("usedgoods 예외 : "+ex);
			}finally{
				try{
					if(rs!=null){
						rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					if(con!=null){
						con.close();
					}
				}catch(Exception ex2){}
			}//finally-end
			
			return list;
		}//usedgoods()-end


}
