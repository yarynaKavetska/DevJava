package less3;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть максимальне число");
		int max = read(sc);
		int cpu = random(1, max);
		int count = 1;
		while(true){
			System.out.println("Введіть число від 1 до "+ max);
			int user = read(sc);
			if(user==cpu){
				System.out.println("Вітаєто Ви перемогли за "+count+" ходів");
				return;
			}else if(user>cpu){
				System.out.println("Ви ввели більше ніж загадав комп");
			}else{
				System.out.println("Ви ввели меньше ніж загадав комп");
			}
			count++;
		}
	}
	
	static int read(Scanner sc){
		if(sc.hasNextInt()){
			return sc.nextInt();
		}
		return 0;
	}

	static int random(int min, int max){
		int random = (int) Math.round(Math.random()*(max-min)+min);
		return random;
	}
}
