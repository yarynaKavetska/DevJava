package core.less1;

public class Main {

	public static void main(String[] args) {
		String str = "Hello";
		String tmp = "Hel";
		String str1 = tmp + "lo";
		System.out.println(str == str1);
		System.out.println(str.charAt(1));
		System.out.println(str.codePointAt(1));
		System.out.println(str.compareTo(str1));
		System.out.println(str.concat(str1));
		System.out.println(str + str1);
		System.out.println(str.contains("eHllo"));
		System.out.println(str.endsWith("llo"));
		System.out.println(str.startsWith("ll", 2));
		System.out.println(str.equals(str1));
		System.out.println(str.indexOf("l"));
		System.out.println(str.indexOf("l", 3));
		System.out.println(str.lastIndexOf("l"));
		System.out.println(str.lastIndexOf("l", 0));
		boolean b = (str != null && !str.isEmpty());
		System.out.println(str.isEmpty());
		System.out.println(str.length());
		System.out.println(str.matches("[A-Za-z]+"));
		System.out.println(str.substring(1, 2));
		System.out.println(str.replaceAll("e", ""));
	}

	static String delete(String str, String del) {
		while (str.indexOf(del) != -1) {
			str = str.substring(0, str.indexOf(del))
					+ str.substring(str.indexOf(del) + del.length(), str.length());
		}
		return str;
	}
}
