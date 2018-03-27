package day09;

public class CompactDisc extends Product{
	private String albumTitle;
	private String aritist;
	
	public CompactDisc(int productID, String description, String maker, int price, String albumTitle, String aritist) {
		super(productID, description, maker, price);
		this.albumTitle = albumTitle;
		this.aritist = aritist;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAritist() {
		return aritist;
	}

	public void setAritist(String aritist) {
		this.aritist = aritist;
	}
	
	public void showInfo() {
		super.showInfo();//부모에 있는 showInfo도 같이 출력해야 하니까 
		System.out.println("앨범 제목>>"+albumTitle);
		System.out.println("가수>>"+aritist);
	}
	
}
