package day09;

public class ConversationBook extends Book{
	private String language;

	public ConversationBook(int productID, String description, String maker, int price, int iSBN, String title,
			String author, String language) {
		super(productID, description, maker, price, iSBN, title, author);
		this.setLanguage(language);
		//this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	public void showInfo() {
		super.showInfo();//부모에 있는 showInfo도 같이 출력해야 하니까 
		System.out.println("언어>>"+language);
	}
}
