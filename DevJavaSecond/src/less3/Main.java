package less3;

import java.util.Scanner;

import static reader.Reader.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isGameEnd = false;
		while (!isGameEnd) {
			System.out.println("Введіть число до якого компютер може загадати змінну");
			int userChoise = read(sc);
			int cpu = random(1, userChoise);
			boolean isRun = true;
			int count = 0;
			while (isRun) {
				System.out.println("Введіть число від 1 до " + userChoise);
				int user = read(sc);
				count++;
				if (cpu == user) {
					System.out.println("Ви перемогли за " + count + " спроб");
					isRun = false;
					System.out.println("Якщо Ви бажаєте ще раз введіть 1");
					if (read(sc) != 1) {
						isGameEnd = true;
					}
				} else if (cpu > user) {
					System.out.println("Ви не вгадали, введіть більше число");
				} else {
					System.out.println("Ви не вгадали, введіть меньше число");
				}
			}
		}
		sc.close();
	}

	static int read(Scanner sc) {
		if (sc.hasNextInt()) {
			return sc.nextInt();
		}
		return 0;
	}

	static int random(int from, int to) {
		int r = (int) Math.round(Math.random() * (to - from) + from);
		return r;
	}
}
