package com.modakdev.cameroscopy.cameroscopydb.configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CameroscopyUser {

    @Id
    private Long id;
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRoles(String roles) {
        this.role = roles;
    }

    @Override
    public String toString() {
        return "CameroscopyUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + role + '\'' +
                '}';
    }
}
