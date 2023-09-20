package Socialapp.Instagram.Controller;

import Socialapp.Instagram.Dtos.Userdto;
import Socialapp.Instagram.Entities.User;
import Socialapp.Instagram.Exception.UserException;
import Socialapp.Instagram.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/allusers")
    public List<User> getAllUser(){
        return userService.allUser();
    }

    @GetMapping("/userdto")
    public List<Userdto> allUserdto()
    {
        return  userService.Userdtoall();
    }

    @PutMapping("updateStatus/{id}/{status}")
    public String update(@PathVariable("id")int id , @PathVariable("status")String status) throws UserException {
        return userService.updateStatus(id,status);
    }


    @PostMapping("/adduser")
    public Userdto addUser(@RequestBody User user){return userService.userAdd(user);}

    @GetMapping("/profile/{status}")
    public List<Userdto> allActiveuser(@PathVariable("status")String status){
        return userService.activeUserAdd(status);
    }
}
