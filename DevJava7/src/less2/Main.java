package less2;

public class Main {

	public static void main(String[] args) {
		double random = Math.random()*10+5;
		int randomInt = (int) Math.round(random);
		System.out.println(randomInt);
		double sqrt = Math.sqrt(16);
		System.out.println(sqrt);
		double s = Math.pow(2, 4);
		System.out.println(s);
		int i = 0;
		while(i<10){
			System.out.print(i);
			i++;
		}
		System.out.println();
		do{
			System.out.println(i+" ");
			i++;
		}while(i<10);
		
		//int j = 0
		for(int j = 0; j < 10; j++){
			System.out.println(Math.random()*10+5);
			//j++
		}
		
		int t;
		if(i>10){
			t=10;
		}else{
			t=20;
		}
		System.out.println(t);
	}
}
