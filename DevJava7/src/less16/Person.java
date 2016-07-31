package less16;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String name;
	
	private int age;
	
	private List<Pet> pets = new ArrayList<>();
	
	public void printPets(){
		class Printer{
			void print(){
				for (Pet pet : pets) {
					System.out.println(pet);
				}
			}
		}
		new Printer().print();
	}
	
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public static class Builder{
		
		private Person person = new Person();
		
		public Builder age(int age){
			person.age=age;
			return this;
		}
		
		public Builder name(String name){
			person.name = name;
			return this;
		}
		
		public Builder addPet(String name){
			Pet pet = person.new Pet(name);
			person.pets.add(pet);
			return this;
		}
		
		public Person build(){
			return person;
		}
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Pet))
				return false;
			Pet other = (Pet) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private Person getOuterType() {
			return Person.this;
		}
	}
}
