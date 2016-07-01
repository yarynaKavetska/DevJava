package core.less4;

public interface Geometric {

	int square();
	
	int perimetr();
	
	public default void print(){
		System.out.println("Squere = "+ this.square() + " Perimetr = "+ this.perimetr());
	}
	
}
