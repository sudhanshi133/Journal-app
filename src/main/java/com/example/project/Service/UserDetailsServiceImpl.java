package com.example.project.Service;

import com.example.project.pojo.UserPojo;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
// so this class is used , when a user logs in
// it takes data (like password) from db against that user converts it into user Details object and returns it to spring security
// this class handle how to compare, check like everything related to authentication
//THIS IS A CONVERSION KIND OF FILE
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPojo user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        UserDetails details = User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRoles().toArray(new String[0]))
                .build();;
                return details;
    }
}
