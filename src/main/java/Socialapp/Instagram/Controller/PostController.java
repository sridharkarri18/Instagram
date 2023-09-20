package Socialapp.Instagram.Controller;

import Socialapp.Instagram.Dtos.Postsdto;
import Socialapp.Instagram.Entities.Posts;
import Socialapp.Instagram.Exception.PostsException;
import Socialapp.Instagram.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("allposts")
    public List<Posts> getAllPosts()
    {
        return postService.allPosts();
    }

    @GetMapping("/postsdto")
    public List<Postsdto> allPostsdto(){
        return postService.postsdtoAll();
    }

    @PostMapping("/addposts")
    public Postsdto  addPosts(@RequestBody Posts posts) {return postService.postsAdd(posts);}

    @DeleteMapping("/delposts/{id}/{uid}")
    public String delPosts(@PathVariable("id")int id,@PathVariable("uid")int uid) throws PostsException {return postService.postsDel(uid,id);}
}
