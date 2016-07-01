package core.less13;

import java.util.Comparator;


public class Main {

	public static void main(String[] args) {
		Person person = new Person.Builder().age(18).name("Ivan").build();
		Person.Builder builder = new Person.Builder();
		builder.age(20).name("Petro");
		Person person2 = builder.build();
		Person.Pet pet = person.new Pet("Barsik");
		Person.Pet pet2 = person2.new Pet("Barsik");
		System.out.println(pet.equals(pet2));
		
		Comparator<Person> ascComparator = new Comparator<Person>() {
			{
				System.out.println("Hello");
			}
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
	}
	
	public static Comparator<Person> getDescComparator(){
		return new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};
	}
	
	public static Comparator<Person> getAscComparator(){
		return (o1, o2) -> o1.getName().compareTo(o2.getName());
	}
	
	public static void doSomething(){
		class Foo{
			
			void foo(){
				
			}
		}
		Foo foo = new Foo();
		foo.foo();
	}
}
