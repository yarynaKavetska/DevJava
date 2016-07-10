package less3;

public class Main {

	public static void main(String[] args) {
//		print();
//		print();
//		int b = 10;
//		print2(b);
//		int c = add(3, 5);
//		System.out.println(c);
		int[] arr = new int[10];
		arr = randomaizer(arr);
		arr = increase(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		int i = 5;
		increm(i);
		System.out.println(i);
	}
	
	static void print(){
		System.out.println("Hello");
	}
	
	static void print2(int i){
		for(int j = 0; j <= i; j++){
			System.out.println(j);
		}
	}
	
	static int add(int a, int b){
		int sum = a + b;
		return sum;
	}
	
	static void increm(int i){
		i++;
	}
	
	static int[] increase(int[] array){
		int[] array2 = new int[array.length+1];
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		return array2;
	}
	
	static int[] randomaizer(int[] array){
		for (int i = 0; i < array.length; i++) {
			array[i] = random(1, 10);
		}
		return array;
	}
	
	static int random(int min, int max){
		int random = (int) Math.round(Math.random()*(max-min)+min);
		return random;
	}
}
