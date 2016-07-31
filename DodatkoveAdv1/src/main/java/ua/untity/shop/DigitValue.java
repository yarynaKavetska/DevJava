package ua.untity.shop;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class DigitValue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private BigDecimal value;
	@ManyToOne
	private DigitProperty digitProperty;
	@ManyToMany(mappedBy="digitValues")
	private List<Item> items;
}
