package Socialapp.Instagram.Repositories;


import Socialapp.Instagram.Entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Postsrepo extends JpaRepository<Posts,Integer> {

    List<Posts> findByuser_id(int uid);

    void deleteByuser_id(int id);
}
