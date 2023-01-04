package com.example.spring_with_mongo_db.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_with_mongo_db.model.RoleModel;
import com.example.spring_with_mongo_db.model.UserModel;
import com.example.spring_with_mongo_db.repository.RoleRepository;
import com.example.spring_with_mongo_db.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		UserModel user = this.userRepo.findByUserName(username);
		
		List<RoleModel> rolesList = this.roleRepo.findAll();
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}else {
			for(RoleModel role : rolesList) {
				for(RoleModel userRole : user.getRoles()) {
					if(role.getId() == userRole.getId()) {
						if(userRole.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
							roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
						}else if (userRole.getRole().equalsIgnoreCase("ROLE_USER")) {
							roles.add(new SimpleGrantedAuthority("ROLE_USER"));
						}
					}
				}
			}
			return new User(user.getUserName(), user.getPassword(), roles);
		}
	}

}
