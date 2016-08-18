package ua.form;

import java.util.List;

public class AmountFilter {

	private int min;
	
	private int max;
	
	private List<Integer> ingredientId;
	
	private List<Integer> msId;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public List<Integer> getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(List<Integer> ingredientId) {
		this.ingredientId = ingredientId;
	}

	public List<Integer> getMsId() {
		return msId;
	}

	public void setMsId(List<Integer> msId) {
		this.msId = msId;
	}

	@Override
	public String toString() {
		return "AmountFilter [min=" + min + ", max=" + max + ", ingredientId="
				+ ingredientId + ", msId=" + msId + "]";
	}
}
