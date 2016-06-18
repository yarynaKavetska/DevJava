package dodatkove.less1;

public class Main {

	public static void main(String[] args) {
		Person p = new Person();
		p.setAge(18);
		p.setName("Ivan");
		Person p1 = new Person(18, "Ivan");
		Velo velo = new Velo(new Rama(19, 
				Color.valueOf("black".toUpperCase())), new Wheel(25));
		System.out.println(velo);
		velo.changeColor(Color.valueOf("red".toUpperCase()));
		velo.getRama().changeColor(Color.RED);
		int diametr = velo.getWheel().getDiametr();
		System.out.println(velo);
		velo.increaseDiametr(3);
		System.out.println(velo);
		System.out.println(findColor("rd"));
		
	}
	
	static Color findColor(String strColor){
		Color[] colors = Color.values();
		Color color = null;
		for (Color eachColor : colors) {
			if(eachColor.name().equals(strColor.toUpperCase())){
				color = eachColor;
			}
		}
		return color;
	}

}
