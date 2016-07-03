package less2;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args){
		int[] array = new int[10];
		int[] array2 = {1,2,3,4,5,6,7,8,9,10};
		for(int i = 0; i < array2.length; i++){
			System.out.println(array2[i]);
		}
		for(int i = 0; i < array.length; i++){
			array[i] = i+1;
			System.out.println(array[i]);
		}
		int a = 4;
		int b = a;
		b = 7;
		System.out.println(a);
		
		int[] array3 = array;
		array3[0] = 50;
		System.out.println(array[0]);
		
		int[] array4 = new int[array.length+1];
		
		for(int i = 0; i < array.length; i++){
			array4[i] = array[i];
		}
		array = array4;
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int userInput = sc.nextInt();
		System.out.println(userInput);
		System.out.println("Enter one more time");
		userInput = sc.nextInt();
		System.out.println(userInput);
	}
}
