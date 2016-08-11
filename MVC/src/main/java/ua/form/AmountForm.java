package ua.form;

import ua.entity.Ingredient;
import ua.entity.MeasuringSystem;

public class AmountForm {

	private int id;
	
	private MeasuringSystem ms;
	
	private Ingredient ingredient;
	
	private String amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MeasuringSystem getMs() {
		return ms;
	}

	public void setMs(MeasuringSystem ms) {
		this.ms = ms;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
