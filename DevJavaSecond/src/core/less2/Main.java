package core.less2;

public class Main {

	public static void main(String[] args) {
		Car car = new Car();
		car.brand = "BMW";
		System.out.println(car.brand);
		car.fuel = 100;
		System.out.println(car.fuel);
		car.maxSpeed = 220;
		System.out.println(car.maxSpeed);
		Car car2 = new Car("Man", 400, 160);
		System.out.println(car2.brand);
		System.out.println(car2.fuel);
		System.out.println(car2.maxSpeed);
		car.drive(200);
		car2.drive(200);
		car.drive(200);
		car.drive(200);
		car.drive(200);
		car.drive(200);
	}
}
