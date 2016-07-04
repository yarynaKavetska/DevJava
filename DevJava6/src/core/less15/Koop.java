package core.less15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Koop {

	private final Map<Person, List<Car>> map = new HashMap<>();
	
	public void addPerson(Person person){
		map.put(person, new ArrayList<>());
	}
	
	public void addCar(Person person, String brand, String model){
		List<Car> cars = map.get(person);
		if(cars!=null)
		cars.add(new Car(brand, model));
	}
	
	public List<Person> findByBrand(String brand){
		List<Person> persons = new ArrayList<>();
//		Set<Entry<Person, List<Car>>> set = map.entrySet();
//		for (Entry<Person, List<Car>> entry : set) {
//			List<Car> cars = entry.getValue();
//			for (Car car : cars) {
//				if(car.getBrand().equalsIgnoreCase(brand)){
//					persons.add(entry.getKey());
//				}
//			}
//		}
		Set<Person> set = map.keySet();
		for (Person person : set) {
			List<Car> cars = map.get(person);
			for (Car car : cars) {
				if(car.getBrand().equalsIgnoreCase(brand)){
					persons.add(person);
				}
			}
		}
		return persons;
	}
	
	public void print(){
//		map.forEach((key, value)->printCars(key, value));
		map.forEach(this::printCars);
	}
	
	public void printCars(Person person, List<Car> cars){
		int len = person.toString().length();
		System.out.print(person);
		if(!cars.isEmpty()){
			System.out.println(cars.get(0));
		}else {
			System.out.println();
		}
		String space = "";
		for(int i = 0; i < len; i++){
			space+=" ";
		}
		for(int i = 1; i < cars.size(); i++){
			System.out.println(space+cars.get(i));
		}
	}

	public Map<Person, List<Car>> getMap() {
		return map;
	}
	
	
}
