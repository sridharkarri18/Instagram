package Socialapp.Instagram.Controller;

import Socialapp.Instagram.Dtos.Commentdto;
import Socialapp.Instagram.Entities.Comment;
import Socialapp.Instagram.Exception.CommentException;
import Socialapp.Instagram.Exception.UserException;
import Socialapp.Instagram.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/allcomments")
    public List<Comment> comments(){
        return commentService.allComments();
    }

    @GetMapping("/commentdto")
    public List<Commentdto> allCommentdto()
    {
        return commentService.commentdtoAll();
    }

    @PostMapping("/addcomment")
    public Commentdto addComment(@RequestBody Comment comment) throws CommentException {
        return  commentService.commentAdd(comment);
    }

    @DeleteMapping("/delcomment/{commentid}")
    public String deleteComment(@PathVariable("commentid")int cid) throws CommentException {
        return commentService.deleteComment(cid);
    }

//    @DeleteMapping("delreplycomment/{commentid}/{userid}")
//    public String deleteRepltComment(@PathVariable("commentid")int cid,@PathVariable("userid") int userid) throws CommentException, UserException {
//        return commentService.deleteReply(cid,userid);
//    }





}
