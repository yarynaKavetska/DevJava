package core.less8;

public class Main {

	public static void main(String[] args) {
		Person p = new Person(18, "Ivan", Sex.MALE);
		Sex m = Sex.MALE;
		System.out.println(m == p.getSex());
		Season season = Season.valueOf("WINTER");
		System.out.println(season);
		Month[] months = Month.values();
		for (Month month : months) {
			System.out.println(month);
			System.out.println(Month.JANUARY.compareTo(month));
			System.out.println(Month.JANUARY.ordinal()-month.ordinal());
		}
	}

}
