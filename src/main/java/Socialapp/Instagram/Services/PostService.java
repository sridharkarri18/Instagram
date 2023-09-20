package Socialapp.Instagram.Services;

import Socialapp.Instagram.Dtos.Postsdto;
import Socialapp.Instagram.Entities.Comment;
import Socialapp.Instagram.Entities.Posts;
import Socialapp.Instagram.Exception.PostsException;
import Socialapp.Instagram.Repositories.Commentrepo;
import Socialapp.Instagram.Repositories.Postsrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    Postsrepo postsrepo;

    @Autowired
    Commentrepo commentrepo;
    public List<Posts> allPosts() {
        return postsrepo.findAll();
    }


    public List<Postsdto> postsdtoAll() {
        List<Posts> posts=postsrepo.findAll();
        List<Postsdto> postsdtos=new ArrayList<>();

        for(var post:posts)
        {
            postsdtos.add(new Postsdto(post));

        }
        return postsdtos;
    }

    public Postsdto postsAdd(Posts post) {

        Posts posts=new Posts();
        posts.setUser_id(post.getUser_id());
        posts.setPosted_time(post.getPosted_time());
        posts.setPosts_id(post.getPosts_id());
        posts.setPostaddress(post.getPostaddress());
        posts.setDeleted_time(post.getDeleted_time());

        Postsdto postsdto=new Postsdto(postsrepo.save(posts));

        return postsdto ;
    }

    @Transactional
    public String postsDel(int uid, int id) throws PostsException {
        List<Posts> posts = postsrepo.findByuser_id(uid);

        if (posts.isEmpty()) {
            return "There are no posts uploaded for user_id";
        } else {
            boolean postFound = false;

            for (var post : posts) {
                int i = post.getPosts_id();
                if (i == id) {
                    List<Comment> comments=commentrepo.findBypcid(id);
                    for(var com:comments){
                        int j=com.getId();
                        commentrepo.deleteBypcid(j);
                    }

                    commentrepo.deleteBypcid(id);
                    postsrepo.deleteById(id);

                    postFound = true;
                    break;
                }
            }

            if (postFound) {
                return "Deleted successfully";
            } else {
                throw new PostsException( "Post with the given ID was not found");
            }
        }


    }

}
