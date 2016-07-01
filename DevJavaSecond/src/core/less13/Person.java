package core.less13;

public class Person {

	private String name = "P";
	
	private int age = 12;

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
		
		private final Person person = new Person();
		
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
	
	public class Pet{
		
		private String nick;

		public Pet(String nick) {
			this.nick = nick;
		}

		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((nick == null) ? 0 : nick.hashCode());
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
			if (nick == null) {
				if (other.nick != null)
					return false;
			} else if (!nick.equals(other.nick))
				return false;
			return true;
		}

		private Person getOuterType() {
			return Person.this;
		}

		@Override
		public String toString() {
			return "Pet [nick=" + nick + "]";
		}
	}
}
