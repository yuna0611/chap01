package day09;

import java.util.Scanner;

public class ProductTest {
	
	static int productID = 0;
	static int nubmerOfProduct = 0;
	static Product[] p = new Product[10];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0; 
		while (choice != 3) {
			int kind;
			System.out.print("상품 추가(1), 모든 상품 조회(2), 끝내기(3)>>");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // 상품 추가
				if (nubmerOfProduct >= p.length) {
					System.out.println("더 이상 추가할 수 없습니다.");
					break;
				}
				System.out.print("상품 종류 : 책(1), 음악CD(2), 회화책(3), 발라드CD(4)>>");
				kind = scanner.nextInt();
				if (kind < 1 || kind > 4) {
					System.out.println("잘못된 상품 종류입니다.");
					break;
				}
				addProduct(kind);
				break;
			case 2: // 모든 상품 조회
				for (int i = 0; i < nubmerOfProduct; i++)
					p[i].showInfo();
				break;
			case 3:// 끝내기
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다");
				break;
			}
		}

	}
	private static void addProduct(int kind) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품 설명>>");
		String desc = scanner.nextLine();
		System.out.print("생산자>>");
		String maker = scanner.nextLine();
		System.out.print("가격>>");
		int price = scanner.nextInt();
		scanner.nextLine();
		switch (kind) {
		case 1://책
			System.out.print("책 제목>>");
			String title=scanner.nextLine();
			System.out.print("저자>>");
			String author=scanner.nextLine();
			System.out.print("ISBN>>");
			int ISBN =scanner.nextInt();
			p[nubmerOfProduct] =new Book(productID++, desc, maker, price, ISBN, title, author);
			break;
		case 2://음악CD
			System.out.print("앨범 제목>>");
			String albumTitle=scanner.nextLine();
			System.out.print("가수>>");
			String artist=scanner.nextLine();
			p[nubmerOfProduct] =new CompactDisc(productID++, desc, maker, price, albumTitle, artist);
			break;
		case 3://회화책
			System.out.print("책 제목>>");
			String title2=scanner.nextLine();
			System.out.print("저자>>");
			String author2=scanner.nextLine();
			System.out.print("언어>>");
			String language=scanner.nextLine();
			System.out.print("ISBN>>");
			int ISBN2 =scanner.nextInt();
			p[nubmerOfProduct] =new ConversationBook(productID++, desc, maker, price, ISBN2, title2, author2, language);
			break;
		case 4://발라드CD
			System.out.print("앨범 제목>>");
			String albumTitle2=scanner.nextLine();
			System.out.print("가수>>");
			String artist2=scanner.nextLine();
			System.out.print("장르>>");
			String genre=scanner.nextLine();
			p[nubmerOfProduct] =new BaladCD(productID++, desc, maker, price, albumTitle2, artist2, genre);
			break;
		}
		nubmerOfProduct++;
	}
}
	/*	int productID = 0, price = 0;
		String description = null,  maker = null;
		int ISBN = 0; 
		String title = null, author = null;
		String albumTitle = null, aritist = null;
		String language = null;
		
		Product p = new Product(productID, description, maker, price);
		Book b = new Book(productID, description, maker, price, ISBN, title, author);
		CompactDisc c = new CompactDisc(productID, description, maker, price, albumTitle, aritist);
		ConversationBook cb = new ConversationBook(productID, description, maker, price, ISBN, albumTitle, author, language);
		int kind;
		int count=0;

		while (true) {
			System.out.print("상품 추가(1), 모든 상품 조회(2), 끝내기(3)>>");
			Scanner scanner = new Scanner(System.in);
			int list = scanner.nextInt();
			String[][] array=new String[3][];
			
			if (list == 1) {
				System.out.print("상품 종류:책(1), 음악CD(2), 회화책(3)>>");
				kind = scanner.nextInt();

				System.out.print("상품ID>>");
				productID = scanner.nextInt();
				System.out.print("상품 설명>>");
				description = scanner.next();
				System.out.print("생산자>>");
				maker = scanner.next();
				System.out.print("가격>>");
				price = scanner.nextInt();
				
				
				switch (kind) {
				case 1:
					b.setProductID(productID);
					b.setDescription(description);
					b.setMaker(maker);
					b.setPrice(price);
					
					System.out.print("ISBN>>");
					ISBN = scanner.nextInt();
					b.setISBN(ISBN);
					
					System.out.print("책 제목>>");
					title = scanner.next();
					b.setTitle(title);
					
					System.out.print("저자>>");
					author = scanner.next();
					b.setAuthor(author);
					break;
				case 2:
					c.setProductID(productID);
					c.setDescription(description);
					c.setMaker(maker);
					c.setPrice(price);
					
					System.out.print("앨범 제목>>");
					albumTitle = scanner.next();
					c.setAlbumTitle(albumTitle);
					
					System.out.print("가수>>");
					aritist = scanner.next();
					c.setAritist(aritist);
					break;
				case 3:
					cb.setProductID(productID);
					cb.setDescription(description);
					cb.setMaker(maker);
					cb.setPrice(price);
					
					System.out.print("언어>>");
					language = scanner.next();
					cb.setLanguage(language);
					break;
				}
			} else if (list == 2) {
					System.out.println("[**책 정보**]\n");
					b.showInfo();
					System.out.println("---------------------------------------\n");
					System.out.println("[**앨범 정보**]\n");
					c.showInfo();
					System.out.println("---------------------------------------\n");
					System.out.println("[**회화책 정보**]\n");
					cb.showInfo();
					System.out.println("---------------------------------------\n");
			
			
			} else if (list == 3) {
				System.err.println("시스템이 종료됩니다");
				System.exit(0);
			}
		}*/

