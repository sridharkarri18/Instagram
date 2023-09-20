package Socialapp.Instagram.Services;

import Socialapp.Instagram.Dtos.Userdto;
import Socialapp.Instagram.Entities.User;
import Socialapp.Instagram.Exception.UserException;
import Socialapp.Instagram.Repositories.Postsrepo;
import Socialapp.Instagram.Repositories.Userrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    Userrepo userrepo;
    @Autowired
    Postsrepo postsrepo;
    public List<User> allUser() {
        return userrepo.findAll();
    }

    public List<Userdto> Userdtoall() {
        List<User> user=userrepo.findAll();
        List<Userdto> userdto=new ArrayList<>();
        for(var users:user)
        {
            userdto.add(new Userdto(users));
        }
        return userdto;
    }

    public Userdto userAdd(User user) {
        User user1=new User();
        user1.setId(user.getId());
        user1.setStatus(user.getStatus());
        user1.setEmail(user.getEmail());
        user1.setPhno(user.getPhno());
        user1.setName(user.getName());
        user1.setPosts(user.getPosts());
        user1.setFollower(user.getFollower());
        user1.setFollowing(user.getFollowing());
        userrepo.save(user1);
         Userdto userdto=new Userdto(user1);
         return userdto;


    }



    @Transactional
    public String updateStatus(int id, String status) throws UserException {
        Optional<User> optionalUser = userrepo.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(user.getStatus()=="inActive")
            {
                return "the given  userid already inactive";
            }
            else {
                user.setStatus(status);
                userrepo.save(user);
                postsrepo.deleteByuser_id(id);

                return "Updated successfully";
            }
        } else {
           throw new UserException("Invalid Data");
        }
    }

    public List<Userdto> activeUserAdd(String status) {
        List<User> activeusers=userrepo.findBystatus(status);
        List<Userdto> userdto= activeusers.stream().map(Userdto::new).toList();
        if(activeusers.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"not found");
        }
        else {
            return userdto;
        }
    }
}
