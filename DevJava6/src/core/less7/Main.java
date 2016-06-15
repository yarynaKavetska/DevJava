package core.less7;

public class Main {

	public static void main(String[] args) {
		University university = new University("LNU", 5);
		university.addFakultet("ПриклМат", 3);
		university.addFakultet("ЮрФак", 1);
		university.addFakultet("ФізМат", 2);
		university.addFakultet("Історичний", 3);
		university.addFakultet("ФізКульт", 2);
		Professor professor = new Professor("Петрович");
		university.addProfessor("ФізКульт", professor);
		System.out.println(university);
	}

}
