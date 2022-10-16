package com.modakdev.cameroscopy.cameroscopydb.api;

import com.modakdev.cameroscopy.cameroscopydb.Response.CameroscopyClientUserResponse;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUser;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUserRepository;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


public class UserOperationsService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserOperationsService.class);
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
    public static CameroscopyClientUserResponse getUser(CameroscopyClientUserRepository repo, String email)
    {
        CameroscopyClientUserResponse response = new CameroscopyClientUserResponse();
        CameroscopyClientUser user1;
        try
        {
           // String email = EncryptionModule.decrypt(encryptedEmail);
            user1 = repo.findByEmail(email);
            if(user1 != null)
            {
                response.setUser(user1);
                response.setMessage("User found");
                response.setStatus(HttpStatus.FOUND);
                // LOGGER.info("EMAIL : "+EncryptionModule.encrypt(email));
                LOGGER.info("Success : "+response.toString());
            }
            else
            {
                response.setMessage("User NOT found");
                response.setStatus(HttpStatus.NOT_FOUND);
                // LOGGER.info("EMAIL : "+EncryptionModule.encrypt(email));
                LOGGER.info("Error : "+response.toString());
            }
        }
        catch (Exception e)
        {
            response.setMessage("Request failed");
            response.setStatus(HttpStatus.BAD_REQUEST);
            LOGGER.error("Exception occurred : "+e);
            LOGGER.error("Error : "+response.toString());
        }
        finally
        {
            return response;
        }
    }
    public static CameroscopyClientUserResponse deleteUser(CameroscopyClientUserRepository repo, CameroscopyClientUser user)
    {
        CameroscopyClientUserResponse response = new CameroscopyClientUserResponse();
        try
        {
         //   user1 = repo.findByEmail(email);
            repo.delete(user);
            response.setUser(user);
            response.setMessage("User deleted");
            response.setStatus(HttpStatus.OK);
            LOGGER.info("Success : "+response.toString());
        }
        catch (Exception e)
        {
            response.setMessage("Request failed");
            response.setStatus(HttpStatus.BAD_REQUEST);
            LOGGER.error("Exception occurred : "+e);
            LOGGER.error("Error : "+response.toString());
        }
        finally
        {
            return response;
        }
    }

}
