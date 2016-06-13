package core.less5;

public interface Geometric {

	int perimetr();
	
	int square();
	
//	public static void print(Geometric geometric){
//		System.out.println("Perimetr = " + geometric.perimetr());
//		System.out.println("Square = " + geometric.square());
//	}
	
	public default void print(){
		System.out.println("Perimetr = " + perimetr());
		System.out.println("Square = " + square());
	}
}
