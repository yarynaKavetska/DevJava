package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	private int level;
	@ManyToOne(fetch=FetchType.LAZY)
	private Category parent;
	@OneToMany
	private List<Category> childs = new ArrayList<>();
	
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		if(parent!=null){
			setLevel(parent.level+1);
			parent.childs.add(this);
		}else{
			setLevel(0);
		}
		this.parent = parent;
	}
	public List<Category> getChilds() {
		return childs;
	}
	public void setChilds(List<Category> childs) {
		this.childs = childs;
	}
}
