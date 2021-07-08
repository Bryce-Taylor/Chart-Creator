package com.example.Chart.Creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CheckedRepository checkedRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }


    public UserDetails loadUserByUsernameRole(String username) throws UsernameNotFoundException {
        User user = userRepo.findByRole(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public List<User> getAllUsersStudents(){
        List<User> listStudents = (List<User>) userRepo.findAll();

        listStudents.removeIf(user -> !user.getIsStudent());


        return listStudents;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public List<User> getUser(){
        return userRepo.findAll();
    }



}