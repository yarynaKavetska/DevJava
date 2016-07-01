package core.less1;

public class Main {

	public static void main(String[] args) {
		String s = "Helolol";
		System.out.println(s);
		String s1 = "Hello";
		String s2 = new String("hello");
		System.out.println(s == s1);
		System.out.println(s.equals(s1));
		System.out.println(s == s2);
		System.out.println(s.equalsIgnoreCase(s2));
		System.out.println(s.charAt(2));
		System.out.println(s.compareTo(s1));
		System.out.println(s != null);
		System.out.println(s + s2);
		System.out.println(s.contains("l"));
		System.out.println(s.endsWith("la"));
		System.out.println(s.indexOf("l"));
		System.out.println(s.indexOf("l", s.indexOf("l") + 1));
		System.out.println(s.lastIndexOf("l"));
		s = s.substring(1, 4);
		System.out.println(delete("Hello", "l"));
		System.out.println(upperCaseFirstLetter("Sjdhjsh sgdhsgdhg jsdghsghd sgdsdsd"));
//		System.out.println(s);
	}
	
	static String upperCaseFirstLetter(String str){
		int position = str.indexOf(" ") + 1;
		while (position != 0) {
			String pre = str.substring(0, position);
			String letter = str.substring(position, position + 1);
			String post = str.substring(position + 1, str.length());
			letter = letter.toUpperCase();
			str = pre + letter + post;
			position = str.indexOf(" ", position)+1;
		}
		return str;
	}

	static String delete(String str, String ch) {
		int position = str.indexOf(ch);
		while (position != -1) {
			System.out.println("first sub = "+str.substring(0, position));
			System.out.println("second sub = "+str.substring(position + 1, str.length()));
			str = str.substring(0, position) + str.substring(position + 1, str.length());
			position = str.indexOf(ch);
		}
		return str;
	}
}
