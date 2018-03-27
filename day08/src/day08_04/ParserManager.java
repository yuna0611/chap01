package day08_04;

public class ParserManager {
	public static Parseable getParser(String type) {
		if (type.equals("XML"))
			return new XMLParser();
		else {
			Parseable p = new HTMLParser();
			return p;
		}
	}
}
