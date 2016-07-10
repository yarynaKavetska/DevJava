package less5;

public class Main {

	public static void main(String[] args) {
		String s = "Ivan";
		s = s + "!";
		System.out.println(s);
		char ch = s.charAt(0);
		System.out.println(ch);
		System.out.println(s.length());
		System.out.println(s.codePointAt(0));
		System.out.println(s.compareTo("Ivan!as"));
		s = s.concat("r");
		System.out.println(s);
		System.out.println(s.contains("!"));
		System.out.println(s.endsWith("!r"));
		System.out.println(s.startsWith("van", 1));
		String s1 = "Ivan!a";
		System.out.println(s == s1);
		System.out.println(s.equals(s1));
		System.out.println(s.indexOf("!r"));
		System.out.println("".isEmpty());
		s = s.replaceAll("!", "()");
		System.out.println(s);
		s = s.substring(1, s.length());
		System.out.println(s);
		s = s.substring(0, 5) + "do" + s.substring(5) + "n";
		System.out.println(s);
		s = remove(s, "()");
		System.out.println(s);
	}

	static String remove(String text, String del) {
		int index = text.indexOf(del);
		if(index>=0){
			text = text.substring(0, index) + text.substring(index + del.length());
		}
		return text;
	}
}
