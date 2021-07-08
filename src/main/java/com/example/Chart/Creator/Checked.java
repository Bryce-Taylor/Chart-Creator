package com.example.Chart.Creator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Checked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Post.class)
    Post post;


    @Column(name="post_id", updatable=false, insertable=false)
    private Long postId;

    @ManyToOne(targetEntity = User.class)
    User user;

    @Column(nullable = false, length = 20)
    String name;

    @Column(name = "joined", nullable = false, length = 20)
    boolean joined = false;

    @Column(name = "check1")
    boolean check1;
    @Column(name = "check2")
    boolean check2;
    @Column(name = "check3")
    boolean check3;

    @Column(name = "check4")
    boolean check4;

    @Column(name = "check5")
    boolean check5;




    public boolean getIsJoined() {
        return joined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public boolean isJoined() {
        return joined;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public boolean isCheck1() {
        return check1;
    }



    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }

    public boolean isCheck2() {
        return check2;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }

    public boolean isCheck3() {
        return check3;
    }

    public void setCheck3(boolean check3) {
        this.check3 = check3;
    }

    public boolean isCheck4() {
        return check4;
    }

    public void setCheck4(boolean check4) {
        this.check4 = check4;
    }

    public boolean isCheck5() {
        return check5;
    }

    public void setCheck5(boolean check5) {
        this.check5 = check5;
    }


}
