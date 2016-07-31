package ua.untity.social;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String all;
	
	@OneToMany(mappedBy="reciver")
	private List<Message> resived;
	@OneToMany(mappedBy="sender")
	private List<Message> sended;
//	@OneToMany
//	private List<MyUser> friends;
//	@OneToMany
//	private List<MyUser> pist;
}
