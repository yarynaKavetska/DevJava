package core.less7;

import java.util.Arrays;

public class University {

	private final String title;
	
	private final Fakultet[] fakultets;

	public University(String title, int fakultets) {
		this.title = title;
		this.fakultets = new Fakultet[fakultets];
	}
	
	public boolean addFakultet(String title, int professors){
		for (int i = 0; i < fakultets.length; i++) {
			if(fakultets[i]==null){
				fakultets[i]=new Fakultet(title, professors);
				System.out.println("Успішно додано факультет "+title);
				return true;
			}
		}
		System.out.println("Нажаль");
		return false;
	}
	
	public boolean addProfessor(String fakultetTitle, Professor professor){
		for (int i = 0; i < fakultets.length; i++) {
			if(fakultets[i]!=null&&fakultets[i].equalsIgnoreCase(fakultetTitle)){
				fakultets[i].addProfessor(professor);
				return true;
			}
		}
		return false;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "University [title=" + title + ", fakultets="
				+ Arrays.toString(fakultets) + "]";
	}
}
