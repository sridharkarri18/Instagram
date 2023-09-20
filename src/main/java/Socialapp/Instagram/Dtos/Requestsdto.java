package Socialapp.Instagram.Dtos;

import Socialapp.Instagram.Entities.Requests;
import lombok.Data;

@Data
public class Requestsdto {

    private int request_id;

    private int sender_id;

    private int receiver_id;

    private String req_status;


    public Requestsdto(Requests requests) {
        this.request_id = requests.getRequest_id();
        this.sender_id = requests.getSender_id();
        this.receiver_id = requests.getReceiver_id();
        this.req_status = requests.getStatus();
    }
}
