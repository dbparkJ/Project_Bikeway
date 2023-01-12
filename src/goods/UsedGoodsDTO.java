package goods;

// 중고 자전거 상품
public class UsedGoodsDTO {
	private String title; // 상품이름
	
	private int price; // 상품가격
	
	private String img; // 상품이미지
	private String Link; // 상품링크
	private String site; // 상품사이트
	
	
	// 게터,세터
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	

}
