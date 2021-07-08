package com.example.Chart.Creator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CheckedRepository extends JpaRepository<Checked, Long> {

//    List<Checked> findByPostId(String postId);

    List<Checked> findByUser(String user);

    @Query("SELECT checked FROM Checked checked WHERE checked.id = ?1")
    Optional<Checked> findById(Long id);

    List<Checked> findByName(String user);

    Optional<Checked> findByPostId(Long id);

}
