package day09;

public class Product {		//부모 클래스에서 공통 객체, 메소드 선언 (private 객체이기 때문에 getter setter 로 접근)
	private int productID;
	private String description;
	private String maker;
	private int price;
	public Product(int productID, String description, String maker, int price) {
		super();
		this.productID = productID;
		this.description = description;
		this.maker = maker;
		this.price = price;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductID() {
		return productID;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("상품ID>>"+productID);
		System.out.println("상품 설명>>"+description);
		System.out.println("생산자>>"+maker);
		System.out.println("가격>>"+price);
	}
}
