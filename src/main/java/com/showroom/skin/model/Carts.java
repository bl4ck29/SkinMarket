package com.showroom.skin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Carts {
    private @Id int cart_id;
    private String user_id;

    public Carts(){}
    public Carts(int cart_id, String user_id){
        this.cart_id = cart_id;
        this.user_id = user_id;
    }

    public int getCartId(){return this.cart_id;}
    public String getUserId(){ return this.user_id;}

    public void setCartId(int cart_id){this.cart_id = cart_id;}
    public void setUserId(String user_id){this.user_id =user_id;}

    public boolean equals(Object other){
        if((other==null) || (other.getClass() != this.getClass())){
            return false;
        }
        Carts cart = (Carts) other;
        return (cart.getCartId() == this.cart_id) && Objects.equals(cart.getUserId(), this.user_id);
    }
}