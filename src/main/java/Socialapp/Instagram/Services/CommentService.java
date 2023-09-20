package Socialapp.Instagram.Services;

import Socialapp.Instagram.Dtos.Commentdto;
import Socialapp.Instagram.Entities.Comment;
import Socialapp.Instagram.Entities.Type;
import Socialapp.Instagram.Exception.CommentException;
import Socialapp.Instagram.Exception.UserException;
import Socialapp.Instagram.Repositories.Commentrepo;
import Socialapp.Instagram.Repositories.Postsrepo;
import Socialapp.Instagram.Repositories.Userrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    Commentrepo commentrepo;
    @Autowired
    Postsrepo postsrepo;
    @Autowired
    Userrepo userrepo;


    public List<Comment> allComments() {
        return commentrepo.findAll();
    }

    public List<Commentdto> commentdtoAll() {
        List<Comment> comments = commentrepo.findAll();
        List<Commentdto> commentdtos = new ArrayList<>();
        for (var comment : comments) {
            commentdtos.add(new Commentdto(comment));
        }
        return commentdtos;
    }


    @Transactional
    public String deleteComment(int cid) throws CommentException {
        if (commentrepo.findById(cid).isPresent()) {
            commentrepo.deleteBypcid(cid);

            commentrepo.deleteById(cid);
            commentrepo.deleteBypcid(cid);
            return "Deleted Succesfuly";
        } else {
            throw new CommentException("Comment Not Found");
        }

    }


    public Commentdto commentAdd(Comment comments) throws CommentException {
        Comment comment = new Comment();
        comment.setId(comments.getId());
        comment.setComment(comments.getComment());
        comment.setUserid(comments.getUserid());
        comment.setPcid(comments.getPcid());
        int id = comment.getPcid();
        var post = postsrepo.findById(id);
        var comments1 = commentrepo.findById(id);

        if (post.isPresent()) {
            comment.setType(Type.post);
        } else if (comments1.isPresent()) {
            comment.setType(Type.comment);
        } else {
            throw new CommentException("hello");
        }
        commentrepo.save(comment);
        Commentdto commentdto1 = new Commentdto(comment);
        return commentdto1;
    }


//    public String deleteReply(int cid,int userid) throws CommentException, UserException {
//        if(commentrepo.findById(cid).isPresent()&&commentrepo.findById(cid).get().getType()==Type.post)
//        {
//            if(commentrepo.findBypcid(cid)&&commentrepo.findByuserid(userid))
//
//
//
//            int userid1=comments.get().getUserid();
//            if(userid1==userid){
//
//                commentrepo.deleteBypcid(cid);
//                return "Deleted Succesfully";
//            }
//            else throw new UserException("the user doesn't commented on particular post");
//        }
//        else throw new CommentException("userid or commentid are invalid");
//
//    }
}


