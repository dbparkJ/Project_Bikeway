package goods;

// 자전거 상품 
public class NewGoodsDTO {
	private String name; // 상품이름
	private String img; // 상품이미지
	private String link; // 상품링크
	private int price; // 상품가격
	
	// 게터,세터
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	

}
