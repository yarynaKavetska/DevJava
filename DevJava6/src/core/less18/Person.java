package core.less18;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	
	private int age;
	
	private List<Pet> pets = new ArrayList<>();
	
	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public class Pet{
		
		private String name;

		public Pet(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public static class Builder{
		
		private Person person = new Person();
		
		public Builder addPet(String name){
			person.pets.add(person.new Pet(name));
			return this;
		}
		
		public Builder name(String name){
			person.name = name;
			return this;
		}
		
		public Builder age(int age){
			person.age = age;
			return this;
		}
		
		public Person build(){
			return person;
		}
	}
}
