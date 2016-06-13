package core.less2;

public class Person {

	int age;
	
	String name;
	
	int count;
	
	Person(){}
	
	Person(int age, String name){
		System.out.println("Name = "+ this.name + ", age = "+ this.age);
		this.age = age;
		System.out.println("Name = "+ this.name + ", age = "+ this.age);
		this.name = name;
		System.out.println("Name = "+ this.name + ", age = "+ this.age);
	}
	
	void walk(int meters){
		count += meters;
		if(count>5000){
			System.out.println(name+":I`m tired");
		}else {
			System.out.println(name+":go-go-go "+ meters + " meters");
		}
	}
}