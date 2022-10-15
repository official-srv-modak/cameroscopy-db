package com.modakdev.cameroscopy.cameroscopydb.Api;

import com.modakdev.cameroscopy.cameroscopydb.Response.CameroscopyClientUserResponse;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUser;
import com.modakdev.cameroscopy.cameroscopydb.configuration.CameroscopyClientUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/user/{email}")
    public CameroscopyClientUserResponse user(@PathVariable("email") String email)
    {
        CameroscopyClientUserResponse response = UserOperationsService.getUser(repo, email);
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
