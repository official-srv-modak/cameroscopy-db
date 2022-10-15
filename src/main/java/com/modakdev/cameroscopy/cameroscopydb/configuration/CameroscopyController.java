package com.modakdev.cameroscopy.cameroscopydb.configuration;

import com.modakdev.cameroscopy.cameroscopydb.Api.UserOperationsService;
import com.modakdev.cameroscopy.cameroscopydb.Response.CameroscopyClientUserResponse;
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
    public CameroscopyClientUser user(@PathVariable("email") String email)
    {

        return repo.findByEmail(email);
    }

    @GetMapping("/create")
    public CameroscopyClientUserResponse createUser(@RequestBody CameroscopyClientUser user)
    {
        CameroscopyClientUserResponse response = UserOperationsService.createUser(repo, user);
        return response;

    }
}
