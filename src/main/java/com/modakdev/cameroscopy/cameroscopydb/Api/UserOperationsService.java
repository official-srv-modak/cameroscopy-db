package com.modakdev.cameroscopy.cameroscopydb.Api;

import com.modakdev.cameroscopy.cameroscopydb.Response.CameroscopyClientUserResponse;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUser;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUserRepository;
import org.springframework.http.HttpStatus;

public class UserOperationsService {

    public static CameroscopyClientUserResponse createUser(CameroscopyClientUserRepository repo, CameroscopyClientUser user)
    {
        CameroscopyClientUserResponse response = new CameroscopyClientUserResponse();
        CameroscopyClientUser user1;
        try
        {
            repo.save(user);
            user1 = user;
            response.setUser(user1);
            response.setMessage("User added");
            response.setStatus(HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            String str = e.getMessage();
            if(str.contains("email_UNIQUE"))
            {
                user1 = repo.findByEmail(user.getEmail());
                response.setUser(user1);
                response.setMessage("User already found");
                response.setStatus(HttpStatus.CONFLICT);
            }
            else
            {
                user1 = repo.findByEmail(user.getEmail());
                response.setUser(user1);
                response.setMessage("Request failed");
                response.setStatus(HttpStatus.NOT_ACCEPTABLE);
            }
        }
        finally
        {
            return response;
        }
    }
}
