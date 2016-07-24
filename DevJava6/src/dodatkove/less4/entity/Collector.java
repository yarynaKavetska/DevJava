package dodatkove.less4.entity;

public class Collector {

	private int id;
	
	private Ingredient ingredient;
	
	private MeasuringSystem measuringSystem;
	
	private int amount;

	public Collector(Ingredient ingredient, MeasuringSystem measuringSystem,
			int amount) {
		this.ingredient = ingredient;
		this.measuringSystem = measuringSystem;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public MeasuringSystem getMeasuringSystem() {
		return measuringSystem;
	}

	public void setMeasuringSystem(MeasuringSystem measuringSystem) {
		this.measuringSystem = measuringSystem;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Collector [id=" + id + ", ingredient=" + ingredient
				+ ", measuringSystem=" + measuringSystem + ", amount=" + amount
				+ "]";
	}
}
