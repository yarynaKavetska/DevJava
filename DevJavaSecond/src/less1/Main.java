package less1;
public class Main {

	public static void main(String[] args) {
		boolean b = true;
		int i = b ? 1 : 2;
		char c = i==1 ? 'a' : 'z';
//		if (!b) {
//			i = 1;
//		} else {
//			i = 2;
//		}
//		System.out.println(i);
		sayHello();
		int h = 5;
		printInt(h);
//		int i = h;
		System.out.println(i);
		printBool(true);
	}
	
	static void sayHello(){
		System.out.println("Hello");
	}
	
	static void printInt(int i){
		System.out.println(i);
	}
	static void printBool(boolean b){
		System.out.println(b);
	}
}
