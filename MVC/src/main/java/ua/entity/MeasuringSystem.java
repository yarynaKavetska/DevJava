package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(indexes=@Index(columnList="name"))
public class MeasuringSystem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@OneToMany(mappedBy="measuringSystem")
	private List<AmountAndIngredient> amountAndIngredients= new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AmountAndIngredient> getAmountAndIngredients() {
		return amountAndIngredients;
	}

	public void setAmountAndIngredients(
			List<AmountAndIngredient> amountAndIngredients) {
		this.amountAndIngredients = amountAndIngredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MeasuringSystem))
			return false;
		MeasuringSystem other = (MeasuringSystem) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
