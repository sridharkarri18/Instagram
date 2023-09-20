package Socialapp.Instagram.Dtos;

import Socialapp.Instagram.Entities.Posts;
import lombok.Data;

import java.time.LocalTime;
@Data
public class Postsdto {

    private int posts_id;
    private String postaddress;
    private LocalTime posted_time;
    private LocalTime deleted_time;
    private int user_id;

    public Postsdto(Posts posts) {
        this.posts_id = posts.getPosts_id();
        this.postaddress = posts.getPostaddress();
        this.posted_time = posts.getPosted_time();
        this.deleted_time = posts.getDeleted_time();
        this.user_id = posts.getUser_id();
    }
}
