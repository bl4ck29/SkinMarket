package com.showroom.skin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
    private @Id int user_id;
    private String user_name, role, login_type, login_email, passwd, user_profile;

    public Users(){}

    public Users(int user_id, String user_name, String role, String login_type, String login_email, String passwd, String user_profile){
        this.user_id = user_id;
        this.user_name = user_name;
        this.role = role; 
        this.login_type = login_type;
        this.login_email = login_email;
        this.passwd = passwd;
        this.user_profile = user_profile;
    }

    public int getUserId(){ return this.user_id;}
    public String getUserName(){ return this.user_name;}
    public String getUserRole(){ return this.role;}
    public String getLoginEmail(){return this.login_email;}
    public String getLoginType(){ return this.login_type;}
    public String getUserPasswd(){ return this.passwd;}
    public String getUserProfile(){return this.user_profile;}

    public void setUserId(int user_id){this.user_id = user_id;}
    public void setUserName(String user_name){this.user_name = user_name;}
    public void setUserRole(String role){this.role = role;}
    public void setLoginType(String login_type){this.login_type = login_type;}
    public void setUserPasswd(String passwd){this.passwd = passwd;}
    public void setUserProfile(String user_profile){this.user_profile = user_profile;}

    @Override
    public boolean equals(Object other){
        if ((other == null) || (other.getClass() != this.getClass())){
            return false;
        }
        Users usr = (Users) other;
        return (usr.getUserId() == this.user_id) && Objects.equals(usr.getUserName(), this.user_name)
        && Objects.equals(usr.getUserRole(), this.role) && Objects.equals(usr.getLoginType(), this.login_type);
    }
    
}
