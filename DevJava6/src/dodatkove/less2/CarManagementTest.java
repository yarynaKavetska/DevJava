package dodatkove.less2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dodatkove.less1.Color;

public class CarManagementTest {
	
	private static final CarManagement CM = new CarManagement();

	@Before
	public void setUp(){
		CM.init();
	}

	@After
	public void tearDown(){
		CM.getCars().clear();
	}

	@Test
	public final void findCarsByDiametrOfWheels() {
		List<Car> actual = CM.findCarsByDiametrOfWheels(18);
		assertTrue(actual.contains(
				new Car("BMW", new Body(Color.RED, Type.COUPE, 1969),
				new Helm(false, 12), new Wheels(18, WheelType.SUMMER))));
		assertEquals(1, actual.size());
	}
	
	@Test
	public final void findCarsByDiametrOfWheelsAndBodyColor(){
		List<Car> actual = CM.findCarsByDiametrOfWheelsAndBodyColor(16, "YELLOW");
		assertTrue(actual.contains(
				new Car("Seat", new Body(Color.YELLOW, Type.HATCHBACK, 1999),
				new Helm(true, 13), new Wheels(16, WheelType.WINTER))));
		assertEquals(1, actual.size());
	}
	
	@Test
	public final void changeHelmInRed(){
		for(Car car : CM.getCars()){
			if(car.getBody().getColor()==Color.RED){
				assertNotEquals(CM.getDefHelm(), car.getHelm());
			}
		}
		CM.changeHelmInRed();
		for(Car car : CM.getCars()){
			if(car.getBody().getColor()==Color.RED){
				assertEquals(CM.getDefHelm(), car.getHelm());
			}
		}
	}
	
	@Test
	public final void increaseDiameterOfWheels(){
		List<Integer> diameters = new ArrayList<>();
		for(Car car : CM.getCars()){
			if(car.getHelm().isHaveButtons()){
				diameters.add(car.getWheels().getDiametr());
			}
		}
		CM.increaseDiameterOfWheels();
		List<Integer> diametersBiggest = new ArrayList<>();
		for(Car car : CM.getCars()){
			if(car.getHelm().isHaveButtons()){
				diametersBiggest.add(car.getWheels().getDiametr()/2);
			}
		}
		assertEquals(diameters, diametersBiggest);
	}
	
	@Test
	public final void replaceAllCarsByDiametrOfWheels(){
		for(Car car : CM.getCars()){
			if(car.getWheels().getDiametr()<18){
				assertNotEquals(CM.getDefCar(), car);
			}
		}
		CM.replaceAllCarsByDiametrOfWheels(18);
		for(Car car : CM.getCars()){
			if(car.getWheels().getDiametr()<18){
				assertEquals(CM.getDefCar(), car);
			}
		}
	}
	
	@Test
	public final void removeByBodyColor(){
		CM.removeByBodyColor("GRAY");
		List<Car> actual = CM.getCars();
		assertTrue(actual.contains(new Car("BMW", new Body(Color.RED, Type.COUPE, 1969),
				new Helm(false, 12), new Wheels(18, WheelType.SUMMER))));
		assertTrue(actual.contains(new Car("Honda", new Body(Color.BLACK, Type.SEDAN, 2001),
				new Helm(true, 14), new Wheels(17, WheelType.ALL_SEASON))));
		assertTrue(actual.contains(new Car("Seat", new Body(Color.YELLOW, Type.HATCHBACK, 1999),
				new Helm(true, 13), new Wheels(16, WheelType.WINTER))));
		assertTrue(actual.contains(new Car("Lamborghini", new Body(Color.YELLOW, Type.HATCHBACK, 2012),
				new Helm(true, 12), new Wheels(22, WheelType.SUMMER))));
		assertEquals(4, actual.size());
	}
	
	@Test
	public final void changeTypeOfWheelsByDiametrOfWheels(){
		List<Car> expected = new ArrayList<>();
		for(Car car : CM.getCars()){
			if(car.getWheels().getDiametr()<20&&car.getWheels().getDiametr()>17){
				expected.add(car);
			}
		}
		CM.changeTypeOfWheelsByDiametrOfWheels(17, 20);
		for (Car car : expected) {
			assertEquals(WheelType.WINTER, car.getWheels().getWheelType());
		}
	}
	
	@Test
	public final void indexes(){
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 6));
		List<Integer> actual = CM.indexes("COUPE");
		assertEquals(expected, actual);
	}
}
