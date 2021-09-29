package com.example.pooja_archana.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    private String name;
    @Column(name = "email", unique = true,nullable = false)
    private String email;
    private String mobile;
    private String gender;
    private String dob;
    @Column(name = "password",nullable = false)
    private String password;
//    @Column(name = "is_active")
    private boolean isActive=true;
    private boolean role=true;

    public UserEntity() { }

    public UserEntity(String name, String email, String mobile, String gender, String dob, String password,  boolean isActive, boolean role) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.dob = dob;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public UserEntity(long uid, String name, String email, String mobile, String gender, String dob, String password, boolean isActive, boolean role) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.dob = dob;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

//    @Override
//    public String toString() {
//        return "UserEntity{" +
//                "uid=" + uid +
////                ", name='" + name + '\'' +
////                ", email='" + email + '\'' +
////                ", mobile='" + mobile + '\'' +
////                ", gender='" + gender + '\'' +
////                ", dob='" + dob + '\'' +
////                ", password='" + password + '\'' +
////                ", isActive=" + isActive +
//                '}';
//    }
}
