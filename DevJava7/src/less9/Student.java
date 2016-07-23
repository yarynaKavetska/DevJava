package less9;

public enum Student {

	IVAN(Kafedra.IT), PAVLO(Kafedra.ECONOMIC), 
	PETRO(Kafedra.ECONOMIC), MYKOLA(Kafedra.IT);

	private Kafedra kafedra;

	private Student(Kafedra kafedra) {
		this.kafedra = kafedra;
	}

	public Kafedra getKafedra() {
		return kafedra;
	}

	public void setKafedra(Kafedra kafedra) {
		this.kafedra = kafedra;
	}
}
