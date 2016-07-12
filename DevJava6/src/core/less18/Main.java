package core.less18;

import static core.less18.Comparators.descStringComparator;
import static core.less18.Car.Type.*;
import static core.less18.Car.Color.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Main {

	static Person person = getPerson();
	
	public static void main(String[] args) {
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		List<String> list = new ArrayList<>();
		list.sort(descStringComparator());
		Comparator<String> desc = descStringComparator();
		
		Car car = new Car.Builder()
			.color(RED)
			.haveButtons(true)
			.helmDiametr(14)
			.season("Winter")
			.type(SEDAN)
			.wheelDiametr(18)
			.build();
		System.out.println(car);
	}
	
	static Person getPerson(){
		return new Person.Builder()
						.age(18)
						.name("Ivan")
						.addPet("Brovko")
						.addPet("Barsik")
						.addPet("Sharik")
						.build();
	}
}
