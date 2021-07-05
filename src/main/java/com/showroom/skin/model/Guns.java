package com.showroom.skin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guns")
public class Guns {
    private @Id int gun_id;
    private String gun_type, gun_name;

    public Guns(){}

    public Guns(int gun_id, String gun_type, String gun_name){
        this.gun_id = gun_id;
        this.gun_type = gun_type;
        this.gun_name = gun_name;
    }

    public int getGunId(){return this.gun_id;}
    public String getGunType(){return this.gun_type;}
    public String getGunName(){return this.gun_name;}

    public void setGunId(int gun_id){this.gun_id = gun_id;}
    public void setGunType(String gun_type){this.gun_type = gun_type;}
    public void setGunName(String gun_name){this.gun_name = gun_name;}

    @Override
    public boolean equals(Object other){
        if ((other==null) || (other.getClass() != this.getClass())){
            return false;
        }
        Guns gun = (Guns) other;
        return (gun.getGunId() == this.gun_id) && Objects.equals(gun.getGunName(), this.gun_name) 
        && Objects.equals(gun.getGunType(), this.gun_type) && Objects.equals(gun.getGunName(), this.gun_name);
    }
}
