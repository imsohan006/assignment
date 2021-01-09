package com.tatsam.assignment.service.Impl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.tatsam.assignment.config.SecurityConfiguration;
import com.tatsam.assignment.dao.Impl.UserDaoImpl;
import com.tatsam.assignment.entity.User;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public String addUser(User user) {
		return userDaoImpl.addIfNotExist(user);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDaoImpl.findByUser(userName);
        if(user!=null) {
			return new org.springframework.security.core.userdetails.User(user.getUser(), new SecurityConfiguration().passwordEncoder().encode(user.getPassword()),
					getAuthorities(user));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String userRoles = user.getRole().name();
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_"+userRoles);
        return authorities;
    }

}
