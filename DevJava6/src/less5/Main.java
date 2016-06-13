package less5;

public class Main {

	static int random(int from, int to) {
		return (int) Math.round(from + ((to - from) * Math.random()));
	}

	public static void main(String[] args) {
		mas10();
	}

	static void mas10() {
		int[] array = new int[10];
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = random(-1, 1);
			if (array[i] == -1) {
				a++;
			} else if (array[i] == 0) {
				b++;
			} else {
				c++;
			}
		}
		if (a > b && a > c) {
			System.out.println("Most often element: -1");
		} else if (b > a && b > c) {
			System.out.println("Most often element: 0");
		} else if (c > a && c > b){
			System.out.println("Most often element: 1");
		}
	}
}
