package com.example.Chart.Creator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Optional;

@Entity
public class Checked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Post.class)
    Optional<Post> post;

    @ManyToOne(targetEntity = User.class)
    User user;

    @Column(name = "column1", nullable = false, length = 20)
    boolean column1 = false;

    @Column(name = "joined", nullable = false, length = 20)
    boolean joined = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Optional<Post> getPost() {
        return post;
    }

    public void setPost(Optional<Post> post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isColumn1() {
        return column1;
    }

    public void setColumn1(boolean column1) {
        this.column1 = column1;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }


}
