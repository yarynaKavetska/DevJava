package core.less2;

public class Car {

	String brand;
	
	double fuel;
	
	int maxSpeed = 10;
	
	Car(){}
	
	Car(String brand, double fuel, int maxSpeed){
		this.brand = brand;
		this.fuel = fuel;
		this.maxSpeed = maxSpeed;
	}
	
	void drive(int km){
		if("BMW".equals(brand))fuel=fuel-km/100*12;
		if("Man".equals(brand))fuel=fuel-km/100*26;
		if(fuel<0){
			System.out.println(brand + ": no brum-brum");
		}else{
			System.out.println(brand + ": brum-brum");
			System.out.println(brand + ": fuel " + fuel);
		}
	}
}
