package core.less17;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Summary {

	public void create(List<Person> persons, String fileName){
		try(FileWriter writer = new FileWriter(fileName+".txt")){
			for (Person person : persons) {
				writer.append(person.getName()+" "+person.getAge()+"\n");
			}
		}catch (IOException e) {
		}
	}
	
	public List<String> read(String fileName){
		List<String> list = new ArrayList<String>();
		try(Scanner sc = new Scanner(new File(fileName+".txt"))){
			while(sc.hasNextLine()){
				list.add(sc.nextLine());
			}
		}catch (IOException e) {
		}
		return list;
	}
}
