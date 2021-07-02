package com.example.Chart.Creator;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT post FROM Post post WHERE post.title = ?1")
    Post findByTitle(String title);
    @Query("SELECT post FROM Post post WHERE post.id = ?1")
    Optional<Post> findById(Long id);
//    public Post findByTitle(String title);
    List<Post> findByCreator(Long id);
}
