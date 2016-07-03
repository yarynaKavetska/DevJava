package dodatkove.less2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import dodatkove.less1.Color;

public class CarManagement {

	private final List<Car> cars = new ArrayList<>();
	
	private final Helm defHelm = new Helm(true, 14);
	
	private final Car defCar = new Car(null, null, null, new Wheels(15, WheelType.SUMMER));

	public void init(){
		cars.add(new Car("Toyota", new Body(Color.GRAY, Type.UNIVERSAL, 1990),
				new Helm(false, 15), new Wheels(15, WheelType.SUMMER)));
		cars.add(new Car("BMW", new Body(Color.RED, Type.COUPE, 1969),
				new Helm(false, 12), new Wheels(18, WheelType.SUMMER)));
		cars.add(new Car("Honda", new Body(Color.BLACK, Type.SEDAN, 2001),
				new Helm(true, 14), new Wheels(17, WheelType.ALL_SEASON)));
		cars.add(new Car("Seat", new Body(Color.YELLOW, Type.HATCHBACK, 1999),
				new Helm(true, 13), new Wheels(16, WheelType.WINTER)));
		cars.add(new Car("Zaz", new Body(Color.GRAY, Type.SEDAN, 2000),
				new Helm(false, 15), new Wheels(14, WheelType.ALL_SEASON)));
		cars.add(new Car("Lamborghini", new Body(Color.YELLOW, Type.HATCHBACK, 2012),
				new Helm(true, 12), new Wheels(22, WheelType.SUMMER)));
		cars.add(new Car("Pagani", new Body(Color.GRAY, Type.COUPE, 2016),
				new Helm(true, 12), new Wheels(20, WheelType.SUMMER)));
	}
	
	public List<Car> findCarsByDiametrOfWheels(int diametr){
//		List<Car> list = new ArrayList<>();
//		for (Car car : cars) {
//			if(car.getWheels().getDiametr()==diametr){
//				list.add(car);
//			}
//		}
//		return list;
		return cars.stream().filter((car)->car.getWheels().getDiametr()==diametr)
				.collect(Collectors.toList());
	}
	
	public List<Car> findCarsByDiametrOfWheelsAndBodyColor
		(int diametr, String bodyColor){
//		List<Car> list = new ArrayList<>();
//		List<Car> filteredByDiametr = findCarsByDiametrOfWheels(diametr);
//		for(Car car : filteredByDiametr){
//			if(car.getBody().getColor().name().equalsIgnoreCase(bodyColor)){
//				list.add(car);
//			}
//		}
//		return list;
		return findCarsByDiametrOfWheels(diametr).stream()
				.filter((car)->car.getBody()!=null)
				.filter((car)->car.getBody().getColor()!=null)
				.filter((car)->car.getBody().getColor().name().equalsIgnoreCase(bodyColor))
				.collect(Collectors.toList());
	}
	
	public void changeHelmInRed() {
//		for (Car car : cars) {
//			if(car.getBody().getColor()==Color.RED){
//				car.setHelm(defHelm);
//			}
//		}
		cars.stream().filter((car)->car.getBody()!=null)
		.filter((car)->car.getBody().getColor()==Color.RED)
		.forEach((car)->car.setHelm(defHelm));
	}
	
	public void increaseDiameterOfWheels(){
//		for(Car car : cars){
//			if(car.getHelm().isHaveButtons()){
//				car.getWheels().setDiametr(car.getWheels().getDiametr()*2);
//			}
//		}
		cars.stream().filter((car)->car.getHelm()!=null)
		.filter((car)->car.getHelm().isHaveButtons())
		.forEach((car)->car.getWheels().setDiametr(car.getWheels().getDiametr()*2));
	}
	
	public void replaceAllCarsByDiametrOfWheels(int diametr){
//		ListIterator<Car> iter = cars.listIterator();
//		while(iter.hasNext()){
//			Car tmp = iter.next();
//			if(tmp.getWheels().getDiametr()<diametr){
//				iter.set(defCar);
//			}
//		}
		cars.replaceAll((car)->{
			if(car.getWheels().getDiametr()<diametr)return defCar;
			return car;
		});
	}
	
	public List<Car> findCarsByBodyType(String bodyType){
//		List<Car> list = new ArrayList<>();
//		for (Car car : cars) {
//			if(car.getBody().getType().name().equals(bodyType.toUpperCase())){
//				list.add(car);
//			}
//		}
//		return list;
		return cars.stream().filter((car)->car.getBody()!=null)
				.filter((car)->car.getBody().getType()!=null)
				.filter((car)->car.getBody().getType().name().equals(bodyType.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public void removeByBodyColor(String bodyColor){
		Iterator<Car> iter = cars.iterator();
		while(iter.hasNext()){
			Car car = iter.next();
			if(car.getBody().getColor().name().equalsIgnoreCase(bodyColor)){
				iter.remove();
			}
		}
	}
	
	public void changeTypeOfWheelsByDiametrOfWheels(int min, int max){
		cars.stream().filter((car)->car.getWheels().getDiametr()<max)
		.filter((car)->car.getWheels().getDiametr()>min)
		.forEach((car)->car.getWheels().setWheelType(WheelType.WINTER));
	}
	
	public List<Integer> indexes(String typeOfBody){
		List<Integer> list = new ArrayList<>();
		int index = 0;
		for(Car car : cars){
			if(car.getBody().getType().name().equalsIgnoreCase(typeOfBody)){
				list.add(index);
			}
			index++;
		}
		return list;
	}
	
	public Helm getDefHelm() {
		return defHelm;
	}

	public Car getDefCar() {
		return defCar;
	}

	public List<Car> getCars() {
		return cars;
	}
}
