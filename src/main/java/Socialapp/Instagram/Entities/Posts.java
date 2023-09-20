package Socialapp.Instagram.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Table(name = "posts")
@Entity
@Data
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="posts_id" )
    @SequenceGenerator(name = "posts_id",sequenceName = "postid",initialValue = 212,allocationSize = 1)
    private int posts_id;
    private String postaddress;
    private LocalTime posted_time;
    private LocalTime deleted_time;
    private int user_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id",nullable =false,insertable = false,updatable = false)
    private User user;

}
