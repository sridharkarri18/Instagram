package Socialapp.Instagram.Controller;

import Socialapp.Instagram.Dtos.Requestsdto;
import Socialapp.Instagram.Entities.Requests;
import Socialapp.Instagram.Services.Requestsservice;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Requestscontroller {

    @Autowired
    Requestsservice requestsservice;


    @GetMapping("/requests")
    @Operation(summary = "Get all requests")
    public List<Requests> allRquests() {
        return requestsservice.requestsAll();
    }

    @GetMapping("requestsdto")
    @Operation(summary = "Get all requestdto")
    public  List<Requestsdto> allRequestsdto(){
        return requestsservice.requestdtoAll();
    }

    @PostMapping("/addrequests")
    @Operation(summary = "Adding record to the request table")
    public Requestsdto addRequests(@RequestBody Requests requests) {return requestsservice.requestsAdd(requests);}

    @GetMapping("/friends")
    @Operation(summary = "Requests who accepted")
    public List<Requestsdto> allFriends() {return requestsservice.friendsAll();}

    @DeleteMapping("/delreq/{id}")
    @Operation(summary = "Deleting the requests in pending status ")
    public String deleteRequest(@PathVariable("id")int id) {
        return requestsservice.requestDelete(id);

    }



}

