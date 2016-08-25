package ua.service.implementation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.MyUser;
import ua.entity.Role;
import ua.repository.MyUserRepository;
import ua.service.MyUserService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, MyUserService{

	@Autowired
	private MyUserRepository myUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return myUserRepository.findByLogin(username);
	}

	@Override
	public void save(MyUser user) {
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		myUserRepository.save(user);
	}
	
	@PostConstruct
	public void postConstruct(){
		MyUser user = myUserRepository.findOne(1);
		if(user == null){
			user = new MyUser();
			user.setId(1);
			user.setLogin("admin");
			user.setRole(Role.ROLE_ADMIN);
			user.setPassword(encoder.encode("admin"));
			myUserRepository.save(user);
		}
	}

}
