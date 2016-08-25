package ua.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.MyUser;
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
		user.setPassword(encoder.encode(user.getPassword()));
		myUserRepository.save(user);
	}

}
