package Socialapp.Instagram.Dtos;

import Socialapp.Instagram.Entities.User;
import lombok.Data;

@Data
public class Userdto {

    private int userid;
    private String name;
    private String email;
    private String phno;
    private int following;
    private int follower;
    private int posts;
    private String status;

    public Userdto(User user) {
        this.userid = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phno = user.getPhno();
        this.following =user.getFollowing();
        this.follower = user.getFollower();
        this.posts = user.getPosts();
    }
}
