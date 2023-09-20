package Socialapp.Instagram.Repositories;


import Socialapp.Instagram.Entities.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Requestsrepo extends JpaRepository<Requests,Integer> {


    List<Requests> findBystatus(String accepted);
}


