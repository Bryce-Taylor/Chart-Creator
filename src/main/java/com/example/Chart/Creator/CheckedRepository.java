package com.example.Chart.Creator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CheckedRepository extends JpaRepository<Checked, Long> {

//    List<Checked> findByPostId(String postId);

    List<Checked> findByUser(String user);

}
