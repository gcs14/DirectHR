package com.gcs14.employeedirectory.service;
import com.gcs14.employeedirectory.model.Users;
import com.gcs14.employeedirectory.model.UserPrincipal;
import com.gcs14.employeedirectory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);

        if(user == null){
            System.out.println("Users Not Found");
            throw new UsernameNotFoundException("Users Not Found");
        }
        return new UserPrincipal(user);
    }
}
