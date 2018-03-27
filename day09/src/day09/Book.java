package day09;

public class Book extends Product{
	private int ISBN; 
	private String title;
	private String author;
	
	
	public Book(int productID, String description, String maker, int price, int iSBN, String title, String author) {
		super(productID, description, maker, price);
		ISBN = iSBN;
		this.title = title;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public void showInfo() {
		super.showInfo();//부모에 있는 showInfo도 같이 출력해야 하니까 
		System.out.println("ISBN>>"+ISBN);
		System.out.println("책 제목>>"+title);
		System.out.println("저자>>"+author);
	}
}
