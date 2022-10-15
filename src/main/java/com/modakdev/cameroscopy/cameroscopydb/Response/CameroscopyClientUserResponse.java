package com.modakdev.cameroscopy.cameroscopydb.Response;

import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUser;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CameroscopyClientUserResponse extends CameroscopyResponse{

    CameroscopyClientUser user;

    public CameroscopyClientUserResponse() {
    }

    public CameroscopyClientUserResponse(CameroscopyClientUser user, String txnDate, String txnTime, HttpStatus status, String message) {
        this.user = user;
        this.txnDate = txnDate;
        this.txnTime = txnTime;
        this.status = status;
        this.message = message;
    }

    public CameroscopyClientUser getUser() {
        return user;
    }

    public void setUser(CameroscopyClientUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CameroscopyClientUserResponse : {" +
                "user=" + user +
                ", txnId='" + txnId + '\'' +
                ", txnDate='" + txnDate + '\'' +
                ", txnTime='" + txnTime + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
