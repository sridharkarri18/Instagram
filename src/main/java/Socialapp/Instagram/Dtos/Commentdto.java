package Socialapp.Instagram.Dtos;

import Socialapp.Instagram.Entities.Comment;
import lombok.Data;

@Data
public class Commentdto {

    private int id;
    private  String comment;
    private String type;
    private int pcid;
    private int userid;

    public Commentdto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.type = String.valueOf(comment.getType());
        this.pcid = comment.getPcid();
        this.userid = comment.getUserid();
    }
}
