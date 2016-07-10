package less4;

public class Person {

	String name;
	
	int age;
	
	Person(String name, int age){
		System.out.println(this.name+" "+this.age);
		this.name = name;
		System.out.println(this.name+" "+this.age);
		this.age = age;
		System.out.println(this.name+" "+this.age);
	}
	
	Person(){
	}
	
	void print(){
		System.out.println(name+" "+age);
	}
}