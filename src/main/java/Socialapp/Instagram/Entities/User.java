package Socialapp.Instagram.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Table(name="users")
@Entity
@Data
public class User {
    @Column(name="users_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id")
    @SequenceGenerator(name="id",sequenceName = "userid",initialValue = 107,allocationSize = 1)
    private int id;
    private String name;
    private String email;
    private String phno;
    private int following;
    private int follower;

    @Column(name="noofposts")
    private int posts;

    private String status;


}
