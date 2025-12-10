package com.testprojg.testproja.securityConfig;

import com.testprojg.testproja.Entity.Person;
import com.testprojg.testproja.Repository.TestRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final TestRepository userRepository;

    public CustomUserDetailsService(TestRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//
//        Optional<Person> person = userRepository.findByName(username);
//        Person user  = person.get();
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
////                .authorities("ROLE_USER") // or from DB
//                .build();
//    }
        @Override
        public UserDetails loadUserByUsername(String username) {

            System.out.println("============================ Trying to find user with name: " + username);
            return userRepository.findByName(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found"));
        }
}

