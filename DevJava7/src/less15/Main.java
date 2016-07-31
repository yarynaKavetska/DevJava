package less15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	private static final Engine ENGINE = restore();
	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add income");
			System.out.println("Enter 2 to add costs");
			System.out.println("Enter 3 to show balance");
			System.out.println("Enter 4 to show incomes");
			System.out.println("Enter 5 to show costs");
			System.out.println("Enter 6 to generate summary");
			System.out.println("Enter 0 to exit");
			switch (SCANNER.next()) {
			case "1": {
				double money = SCANNER.nextDouble();
				ENGINE.addIncome(money);
				save();
				break;
			}
			case "2": {
				double money = SCANNER.nextDouble();
				ENGINE.addCost(money);
				save();
				break;
			}
			case "3": {
				ENGINE.showBalance();
				break;
			}
			case "4": {
				ENGINE.showIncomes();
				break;
			}
			case "5": {
				ENGINE.showCosts();
				break;
			}
			case "6": {
				System.out.println("Enter year");
				int year = SCANNER.nextInt();
				System.out.println("Enter month");
				int month = SCANNER.nextInt();
				System.out.println("Enter day");
				int day = SCANNER.nextInt();
				System.out.println("Enter name of file");
				String fileName = SCANNER.next();
				ENGINE.generateSummaryByCosts(fileName, 
						LocalDateTime.of(LocalDate
								.of(year, month, day),
								LocalTime.now()));
				break;
			}
			default:
				isRun=false;
			}
		}
	}
	
	private static void save(){
		try(OutputStream os = new FileOutputStream(new File("save.dfr"));
				ObjectOutputStream oos = new ObjectOutputStream(os)){
			oos.writeObject(ENGINE);
			oos.flush();
		}catch (IOException e) {
		}
	}
	
	private static Engine restore(){
		try(InputStream is = new FileInputStream(new File("save.dfr"));
				ObjectInputStream ois = new ObjectInputStream(is)){
			return (Engine) ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
		}
		return new Engine();
	}

}
