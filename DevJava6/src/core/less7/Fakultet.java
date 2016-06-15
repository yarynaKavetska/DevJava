package core.less7;

import java.util.Arrays;

public class Fakultet {

	private final String title;
	
	private final Professor[] professors;

	public Fakultet(String title, int professors) {
		this.title = title;
		this.professors = new Professor[professors];
	}
	
	public boolean addProfessor(Professor professor){
		for (int i = 0; i < professors.length; i++) {
			if(professors[i]==null){
				professors[i] = professor;
				System.out.println("Успішно прийнятий на роботу "+professor.getName());
				return true;
			}
		}
		System.out.println("Місць немає!!!");
		return false;
	}

	public boolean equalsIgnoreCase(String anotherString) {
		if(title==null)return false;
		return title.equalsIgnoreCase(anotherString);
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Fakultet [title=" + title + ", professors="
				+ Arrays.toString(professors) + "]";
	}
}
