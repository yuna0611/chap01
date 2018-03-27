package day09;

public class BaladCD extends CompactDisc{
	private String genre;

	public BaladCD(int productID, String description, String maker, int price, String albumTitle, String aritist,
			String genre) {
		super(productID, description, maker, price, albumTitle, aritist);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Àå¸£>>"+genre);
	}
	
}
