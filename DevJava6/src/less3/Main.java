package less3;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int a = getInt(sc);
//		System.out.println(a);
		double d = Math.random();
		System.out.println(d);
		sc.close();
	}
	
	static int getInt(Scanner sc){
		if(sc.hasNextInt()){
			int result = sc.nextInt();
			return result;
		}
		return 0;
	}
	
	
}
