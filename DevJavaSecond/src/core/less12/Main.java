package core.less12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {

	private static PersonManagement pm = restore("saves.person");
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to save all persons");
			System.out.println("Enter 3 to clear all persons");
			System.out.println("Enter 4 to show all persons");
			System.out.println("Enter 5 to generate summary");
			System.out.println("Enter 6 to read summary");
			System.out.println("Enter 0 to exit");
			switch (SC.next()) {
			case "1": {
				addPerson();
				break;
			}
			case "2": {
				save("saves.person");
				break;
			}
			case "3": {
				pm.clear();
				break;
			}
			case "4": {
				System.out.println(pm);
				break;
			}
			case "5": {
				genareteSummary("summary.txt");
				break;
			}
			case "6": {
				readSummary("summary.txt");
				break;
			}
			default: {
				isRun = false;
				SC.close();
				break;
			}
			}
		}
	}

	private static void readSummary(String path) {
		File file = new File(path);
		try(Scanner sc = new Scanner(file)){
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
		}catch (IOException e) {
		}
	}

	private static void genareteSummary(String path) {
		File file = new File(path);
		try(FileWriter fw = new FileWriter(file)){
			for(String s : pm.forSummary())
			fw.append(s+"\n");
		}catch (IOException e) {
		}
	}

	private static PersonManagement restore(String path) {
		File file = new File(path);
		try(InputStream is = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(is)){
			Object obj = ois.readObject();
			if(obj instanceof PersonManagement){
				return (PersonManagement) obj;
			}
		}catch (IOException | ClassNotFoundException e){
		}
		return new PersonManagement();
	}

	private static void save(String path) {
		File file = new File(path);
		try(OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os)){
			oos.writeObject(pm);
			oos.flush();
		}catch (IOException e) {
		}
	}

	private static void addPerson() {
		System.out.println("Enter name");
		String name = SC.next();
		System.out.println("Enter age");
		String age = SC.next();
		pm.addPerson(name, age);
	}

}
