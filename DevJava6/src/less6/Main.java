package less6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть верхню межу для компютера");
		int userChoice = read(sc);
		int cpu = random(1, userChoice);
		boolean isRun = true;
		while(isRun){
			System.out.println("Введіть число від 1 до " + userChoice);
			int user = read(sc);
			isRun = cpu != user;
			if(cpu > user)System.out.println();
			if(cpu < user)System.out.println();
		}
		System.out.println("Ви перемогли");
	}
	
	static int read(Scanner sc){
		if(sc.hasNextInt()){
			return sc.nextInt();
		}
		return 0;
	}

	static int random(int from, int to){
		return (int) Math.round(Math.random()*(to-from)+from);
	}
	
	
}
