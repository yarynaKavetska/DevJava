package less15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Serializable{

	private static final long serialVersionUID = 4715202434595043292L;

	private double balance;
	
	private List<Check> costs = new ArrayList<>();
	
	private List<Check> incomes = new ArrayList<>();
	
	public void addCost(double money){
		costs.add(new Check(money));
		balance-=money;
	}
	
	public void addIncome(double money){
		incomes.add(new Check(money));
		balance+=money;
	}
	
	public void showBalance(){
		System.out.println("Your balance: "+balance);
	}
	
	public void showCosts(){
		System.out.println("All costs:");
		costs.forEach(System.out::println);
	}
	
	public void showIncomes(){
		System.out.println("All incomes:");
		incomes.forEach(System.out::println);
	}
	
	public void generateSummaryByCosts(String fileName, LocalDateTime date){
		File file = new File(fileName+".txt");
		try(FileWriter fw = new FileWriter(file)){
			for(Check check : costs){
				if(check.getDate().isAfter(date)){
					fw.append(check.toString()+"\n");
				}
			}
		}catch (IOException e) {
		}
	}
}
