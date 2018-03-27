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
			System.out.print("��ǰ �߰�(1), ��� ��ǰ ��ȸ(2), ������(3)>>");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: // ��ǰ �߰�
				if (nubmerOfProduct >= p.length) {
					System.out.println("�� �̻� �߰��� �� �����ϴ�.");
					break;
				}
				System.out.print("��ǰ ���� : å(1), ����CD(2), ȸȭå(3), �߶��CD(4)>>");
				kind = scanner.nextInt();
				if (kind < 1 || kind > 4) {
					System.out.println("�߸��� ��ǰ �����Դϴ�.");
					break;
				}
				addProduct(kind);
				break;
			case 2: // ��� ��ǰ ��ȸ
				for (int i = 0; i < nubmerOfProduct; i++)
					p[i].showInfo();
				break;
			case 3:// ������
				System.exit(0);
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				break;
			}
		}

	}
	private static void addProduct(int kind) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ǰ ����>>");
		String desc = scanner.nextLine();
		System.out.print("������>>");
		String maker = scanner.nextLine();
		System.out.print("����>>");
		int price = scanner.nextInt();
		scanner.nextLine();
		switch (kind) {
		case 1://å
			System.out.print("å ����>>");
			String title=scanner.nextLine();
			System.out.print("����>>");
			String author=scanner.nextLine();
			System.out.print("ISBN>>");
			int ISBN =scanner.nextInt();
			p[nubmerOfProduct] =new Book(productID++, desc, maker, price, ISBN, title, author);
			break;
		case 2://����CD
			System.out.print("�ٹ� ����>>");
			String albumTitle=scanner.nextLine();
			System.out.print("����>>");
			String artist=scanner.nextLine();
			p[nubmerOfProduct] =new CompactDisc(productID++, desc, maker, price, albumTitle, artist);
			break;
		case 3://ȸȭå
			System.out.print("å ����>>");
			String title2=scanner.nextLine();
			System.out.print("����>>");
			String author2=scanner.nextLine();
			System.out.print("���>>");
			String language=scanner.nextLine();
			System.out.print("ISBN>>");
			int ISBN2 =scanner.nextInt();
			p[nubmerOfProduct] =new ConversationBook(productID++, desc, maker, price, ISBN2, title2, author2, language);
			break;
		case 4://�߶��CD
			System.out.print("�ٹ� ����>>");
			String albumTitle2=scanner.nextLine();
			System.out.print("����>>");
			String artist2=scanner.nextLine();
			System.out.print("�帣>>");
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
			System.out.print("��ǰ �߰�(1), ��� ��ǰ ��ȸ(2), ������(3)>>");
			Scanner scanner = new Scanner(System.in);
			int list = scanner.nextInt();
			String[][] array=new String[3][];
			
			if (list == 1) {
				System.out.print("��ǰ ����:å(1), ����CD(2), ȸȭå(3)>>");
				kind = scanner.nextInt();

				System.out.print("��ǰID>>");
				productID = scanner.nextInt();
				System.out.print("��ǰ ����>>");
				description = scanner.next();
				System.out.print("������>>");
				maker = scanner.next();
				System.out.print("����>>");
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
					
					System.out.print("å ����>>");
					title = scanner.next();
					b.setTitle(title);
					
					System.out.print("����>>");
					author = scanner.next();
					b.setAuthor(author);
					break;
				case 2:
					c.setProductID(productID);
					c.setDescription(description);
					c.setMaker(maker);
					c.setPrice(price);
					
					System.out.print("�ٹ� ����>>");
					albumTitle = scanner.next();
					c.setAlbumTitle(albumTitle);
					
					System.out.print("����>>");
					aritist = scanner.next();
					c.setAritist(aritist);
					break;
				case 3:
					cb.setProductID(productID);
					cb.setDescription(description);
					cb.setMaker(maker);
					cb.setPrice(price);
					
					System.out.print("���>>");
					language = scanner.next();
					cb.setLanguage(language);
					break;
				}
			} else if (list == 2) {
					System.out.println("[**å ����**]\n");
					b.showInfo();
					System.out.println("---------------------------------------\n");
					System.out.println("[**�ٹ� ����**]\n");
					c.showInfo();
					System.out.println("---------------------------------------\n");
					System.out.println("[**ȸȭå ����**]\n");
					cb.showInfo();
					System.out.println("---------------------------------------\n");
			
			
			} else if (list == 3) {
				System.err.println("�ý����� ����˴ϴ�");
				System.exit(0);
			}
		}*/

