package core.less7;


public class Main {
	
	public static void main(String[] args) {
		Person person = new Person
				("Ivan", 18, Sex.valueOf("MALE"));
		Month[] months = Month.values();
		for (Month month : months) {
			if(month.getDays()==31)
			System.out.println(month);
		}
		System.out.println(Month.APRIL.getSeason()==Season.SUMMER);
//		System.out.println(Month.APRIL);
//		System.out.println(Month.APRIL.name());
//		System.out.println(Month.APRIL.compareTo(Month.OCTOBER));
	}
}
