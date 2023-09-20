package Socialapp.Instagram.Services;


import Socialapp.Instagram.Dtos.Requestsdto;
import Socialapp.Instagram.Dtos.Userdto;
import Socialapp.Instagram.Entities.Requests;
import Socialapp.Instagram.Entities.User;
import Socialapp.Instagram.Repositories.Requestsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Requestsservice {
    @Autowired
    Requestsrepo requestsrepo;

    public List<Requests> requestsAll() {return requestsrepo.findAll();}




    public List<Requestsdto> friendsAll() {
        List<Requests> requests= requestsrepo.findBystatus("accepted");
        List<Requestsdto> requestsdto=requests.stream().map(Requestsdto::new).toList();
        return requestsdto;

    }

    public String requestDelete(int id) {
        List<Requests> requests = requestsrepo.findBystatus("pending");

        if(requests.isEmpty())
        {
            return "No pending request";
        }
        else {
            boolean requestfound=false;

            for(var req:requests)
            {
                if(req.getRequest_id()==id)
                {
                    requestsrepo.deleteById(id);
                    requestfound=true;
                    break;
                }

            }
            if(requestfound)
            {
                return "pending status request deleted Successfully";
            }
            else {
                return "request with the given id not found in pending status list";
            }

        }
    }

    public List<Requestsdto> requestdtoAll() {

        List<Requests> requests=requestsrepo.findAll();
        List<Requestsdto> requestsdtos=new ArrayList<>();
        for(var req:requests)
        {
            requestsdtos.add(new Requestsdto(req));
        }
        return requestsdtos;
    }

    public Requestsdto requestsAdd(Requests requests) {
        Requests requests1=new Requests();
        requests1.setReceiver_id(requests.getReceiver_id());
        requests1.setSender_id(requests.getSender_id());
        requests1.setStatus(requests.getStatus());
        requestsrepo.save(requests1);
        Requestsdto requestsdto=new Requestsdto(requests1);
        return requestsdto;

    }
}
