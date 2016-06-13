package less2;

public class Main {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		boolean bool = a < b;
		if (bool) {
			System.out.println("In if case");
		} else if(a > b) {
			System.out.println("In else if case");
		} else {
			System.out.println("In else case");
		}
		switch (a) {
		case 1 :{
			System.out.println("One");
			break;
		}
		case 2 :{
			System.out.println("Two");
			break;
		}
		case 3 :{
			System.out.println("Three");
			break;
		}
		default :{
			System.out.println("Default");
		}
		}
		int c = 7;
		if (c < 10){
			System.out.println("c < 10");
		} else {
			System.out.println("c > 10");
		}
//		int i = 0;
//		while(i<10){
//			System.out.println(++i);
//		}
//		do{
//			System.out.println(++i);
//		}while(i<10);
		for(int i = 0; i < 10; i++){
			System.out.println(i);
		}
	}

}
