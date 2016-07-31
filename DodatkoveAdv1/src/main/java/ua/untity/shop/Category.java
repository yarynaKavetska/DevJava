package ua.untity.shop;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@OneToMany
	private List<Category> childs;
	@ManyToOne
	private Category parent;
	@OneToMany(mappedBy="category")
	private List<StringProperty> stringProperties;
	@OneToMany(mappedBy="category")
	private List<DigitProperty> digitProperties;
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
	public List<Category> getChilds() {
		return childs;
	}
	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public List<StringProperty> getStringProperties() {
		return stringProperties;
	}
	public void setStringProperties(List<StringProperty> stringProperties) {
		this.stringProperties = stringProperties;
	}
	public List<DigitProperty> getDigitProperties() {
		return digitProperties;
	}
	public void setDigitProperties(List<DigitProperty> digitProperties) {
		this.digitProperties = digitProperties;
	}
}
