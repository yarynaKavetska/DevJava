package core.less18;

public class Car {
	
	private Body body = new Body();
	
	private Helm helm = new Helm();
	
	private Wheel wheel = new Wheel();
	
	public static class Builder{
		
		private Car car = new Car();
		
		public Builder type(Type type){
			car.body.type = type;
			return this;
		}
		
		public Builder color(Color color){
			car.body.color = color;
			return this;
		}
		
		public Builder helmDiametr(int diametr){
			car.helm.diametr = diametr;
			return this;
		}
		
		public Builder haveButtons(boolean haveButtons){
			car.helm.haveButtons = haveButtons;
			return this;
		}
		
		public Builder wheelDiametr(int diametr){
			car.wheel.diametr = diametr;
			return this;
		}
		
		public Builder season(String season){
			car.wheel.season = season;
			return this;
		}
		
		public Car build(){
			return car;
		}
	}

	private class Body{
		
		private Type type;
		
		private Color color;

		@Override
		public String toString() {
			return "Body [type=" + type + ", color=" + color + "]";
		}
	}
	
	private class Helm{
		
		private int diametr;
		
		private boolean haveButtons;

		@Override
		public String toString() {
			return "Helm [diametr=" + diametr + ", haveButtons=" + haveButtons
					+ "]";
		}
	}
	
	private class Wheel{
		
		private int diametr;
		
		private String season;

		@Override
		public String toString() {
			return "Wheel [diametr=" + diametr + ", season=" + season + "]";
		}
	}
	
	public static enum Type{
		SPIDER, SEDAN;
	}
	
	public static enum Color{
		RED, GREEN, GREY, BLACK, WHITE;
	}

	@Override
	public String toString() {
		return "Car [body=" + body + ", helm=" + helm + ", wheel=" + wheel
				+ "]";
	}
}
