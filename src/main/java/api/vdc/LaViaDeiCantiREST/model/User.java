package api.vdc.LaViaDeiCantiREST.model;

import api.vdc.LaViaDeiCantiREST.utils.UserStatus;
import api.vdc.LaViaDeiCantiREST.utils.UserType;

import javax.persistence.*;

/**
 * Class User
 */
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @Column(name = "username")
    private String username  = "";
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType user_type;
    @Column(name = "salt")
    private byte[] salt;
    @Column(name = "hash")
    private byte[] hash;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Transient
    private String password;

    //Getters & Setters


    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }
}
