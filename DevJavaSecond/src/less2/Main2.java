package less2;

public class Main2 {

	public static void main(String[] args) {
		int[] array = new int[10];
		insert(array);
		print(array);
		int i = 0;
		increment(i);
//		System.out.println(i);
	}
	
	static void increment(int i){
		i++;
	}
	
	static void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}

	static void insert(int[] array){
		for(int i = 0; i < array.length; i++){
			array[i] = array.length - i;
		}
	}
}
