package less4;

public class Main {

	public static void main(String[] args) {
		int length = 10;
		int[] array = new int[length];
		System.out.println(array);
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
			System.out.println(array[i]);
		}
		boolean[] bool = new boolean[2];
		bool[0] = true;
		for (int i = 0; i < bool.length; i++) {
			System.out.println(bool[i]);
		}
		char[] charArray = new char[10];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = (char) (i + 65);
			System.out.println(charArray[i]);
		}
		System.out.println(charArray);
		int[] arrayInt = array;
		arrayInt[0] = 50;
		System.out.println(array);
		System.out.println(arrayInt);
		int a = 5;
		int b = a;
		a =7;
		System.out.println(a);
		System.out.println(b);
		insert(arrayInt);
		System.out.println("Method test");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	static void insert(int[] ar){
		for (int i = 0; i < ar.length; i++) {
			ar[i] = random(1, 10);
		}
	}

	static int random(int from, int to) {
		return (int) Math.round(from + ((to - from) * Math.random()));
	}

}
