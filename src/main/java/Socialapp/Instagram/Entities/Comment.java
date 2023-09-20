package Socialapp.Instagram.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "comment")
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="id" )
    @SequenceGenerator(name = "id",sequenceName ="cid",initialValue = 309,allocationSize = 1)
    private int id;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int pcid;

    @Column(name = "user_id")
    private int userid;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id",nullable =false,insertable = false,updatable = false)
    private User user;

}
