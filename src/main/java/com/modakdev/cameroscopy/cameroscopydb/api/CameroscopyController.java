package com.modakdev.cameroscopy.cameroscopydb.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.modakdev.cameroscopy.cameroscopydb.Response.CameroscopyClientUserResponse;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUser;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUserRepository;
import com.modakdev.cameroscopy.cameroscopydb.configuration.EmailClass;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameroscopyController {


    @Autowired
    CameroscopyClientUserRepository repo;

    @GetMapping("/home")
    public String home()
    {
        return "HOME";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "ADMIN";
    }

    @RequestMapping("/user")
    public CameroscopyClientUserResponse user(@RequestBody EmailClass emailObj)
    {
        CameroscopyClientUserResponse response = UserOperationsService.getUser(repo, emailObj.getEmail());
        return response;
    }

    @GetMapping("/create")
    public CameroscopyClientUserResponse createUser(@RequestBody CameroscopyClientUser user)
    {
        CameroscopyClientUserResponse response = UserOperationsService.createUser(repo, user);
        return response;

    }

    @GetMapping("/delete")
    public CameroscopyClientUserResponse deleteUser(@RequestBody CameroscopyClientUser user)
    {
        CameroscopyClientUserResponse response = UserOperationsService.deleteUser(repo, user);
        return response;

    }
}
