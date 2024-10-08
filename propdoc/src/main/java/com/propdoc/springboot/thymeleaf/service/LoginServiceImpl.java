package com.propdoc.springboot.thymeleaf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.propdoc.springboot.thymeleaf.dao.LoginRepository;
import com.propdoc.springboot.thymeleaf.dao.LoginRoleRepository;
import com.propdoc.springboot.thymeleaf.entity.Login;
import com.propdoc.springboot.thymeleaf.entity.LoginRegistrationDto;
import com.propdoc.springboot.thymeleaf.entity.LoginRole;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository userRepository;

	@Autowired
	private LoginRoleRepository userRoleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Login findByEmpid(String empid) {
		return userRepository.findByEmpid(empid);
	}

	public Login save(LoginRegistrationDto registration, String privilege) {

		ArrayList<LoginRole> ls = new ArrayList<LoginRole>();
		// ls.add(new LoginRole(null,privilege));
		ls.add(userRoleRepository.findByRole(privilege));

		Login user = new Login();
		user.setEmpid(registration.getEmpid());
		user.setPassword(passwordEncoder.encode(registration.getEmpid()));
		user.setRoles(ls);
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String empid) throws UsernameNotFoundException {
		Login user =null;
		empid=empid.toUpperCase();
		
		if (empid.contains("PD")) {
			empid= String.valueOf(Integer.parseInt(empid.replace("PD","")));
			
			user = userRepository.findByEmpid(empid);

			if (user == null) {
				throw new UsernameNotFoundException("Invalid username or password.");
			}
		} else {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmpid(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<LoginRole> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public Login savePasswordchange(Login obj) {

		return userRepository.save(obj);
	}

	public Login resetall(LoginRegistrationDto registration, String privilege, long id) {

		ArrayList<LoginRole> ls = new ArrayList<LoginRole>();
		ls.add(userRoleRepository.findByRole(privilege));

		Login user = new Login();
		user.setId(id);
		user.setEmpid(registration.getEmpid());
		user.setPassword(registration.getPassword());
		user.setRoles(ls);
		
		return userRepository.save(user);
	}

}
