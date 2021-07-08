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

    List<Checked> findByPostId(Long id);

//    @Query("SELECT c FROM Checked c WHERE c.post_id = ?1 AND c.user_id = ?2")
//    Checked findByPostIdAndUserId(Long postId, Long userId);

}
