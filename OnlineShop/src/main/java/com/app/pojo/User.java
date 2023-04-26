package com.app.pojo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "INTEGER")
    private int UserId;

    @Column(name = "Name", columnDefinition = "VARCHAR(99)")
    private String UserName;

    @Column(name = "Surname", columnDefinition = "VARCHAR(99)")
    private String UserSurname;

    @Column(name = "Phone", columnDefinition = "VARCHAR(20)")
    private String UserPhone;

    @Column(name = "Email", columnDefinition = "VARCHAR(99)")
    private String UserEmail;

    @Column(name = "Registred", columnDefinition = "DATE")
    private LocalDate UserRegistredDate;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSurname() {
        return UserSurname;
    }

    public void setUserSurname(String userSurname) {
        UserSurname = userSurname;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public LocalDate getUserRegistredDate() {
        return UserRegistredDate;
    }

    public void setUserRegistredDate(LocalDate userRegistredDate) {
        UserRegistredDate = userRegistredDate;
    }

}
