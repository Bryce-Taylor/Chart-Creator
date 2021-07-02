package com.example.Chart.Creator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.Chart.Creator.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.typeOfRole = ?1")
    public User findByRole(String role);
}
