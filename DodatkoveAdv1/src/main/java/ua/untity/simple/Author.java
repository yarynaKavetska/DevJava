package ua.untity.simple;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@ManyToMany
	@JoinTable(name="author_book", joinColumns = 
	@JoinColumn(name = "author_id"), inverseJoinColumns = 
	@JoinColumn(name = "book_id"))
	private List<Book> books;
}
