package com.modakdev.cameroscopy.cameroscopydb.configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static com.modakdev.cameroscopy.cameroscopydb.api.EncryptionModule.decrypt;
import static com.modakdev.cameroscopy.cameroscopydb.api.EncryptionModule.encrypt;

@Entity
public class CameroscopyClientUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String role;

    public CameroscopyClientUser(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public CameroscopyClientUser() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String roles) {
        this.role = roles;
    }

    @Override
    public String toString() {
        return "CameroscopyClientUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public CameroscopyClientUser decryptObject()
    {
        CameroscopyClientUser output = new CameroscopyClientUser();
        output.email = decrypt(email);
        output.firstname = decrypt(firstname);
        output.lastname = decrypt(lastname);
        output.role = decrypt(role);
        return output;
    }

    public CameroscopyClientUser encryptObject()
    {
        CameroscopyClientUser output = new CameroscopyClientUser();
        output.email = encrypt(email);
        output.firstname = encrypt(firstname);
        output.lastname = encrypt(lastname);
        output.role = encrypt(role);
        return output;
    }
}
