package goods;

// 중고 자전거 상품
public class UsedGoodsDTO {
	private String name; // 상품이름
	private String img; // 상품이미지
	private String link; // 상품링크
	private Integer price; // 상품가격
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
