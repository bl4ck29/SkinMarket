package com.showroom.skin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Table(name = "transactions")
public class Transactions{
    private @Id int trans_id;
    private String cart_id, item_id, status;
    private Timestamp update_time;

    public Transactions(){}
    public Transactions(int trans_id, String cart_id, String status, Timestamp update_time){
        this.trans_id = trans_id;
        this.cart_id = cart_id;
        this.status = status;
        this.update_time = update_time;
    }

    public int getTransId(){return this.trans_id;}
    public String getCartId(){return this.cart_id;}
    public String getItemId(){return this.item_id;}
    public String getTransStatus(){return this.status;}
    public Timestamp getUpdateTime(){return this.update_time;}

    public void setTransId(int trans_id){this.trans_id = trans_id;}
    public void setCartId(String cart_id){this.cart_id = cart_id;}
    public void setItemId(String item_id){this.item_id = item_id;}
    public void setTransStatus(String status){this.status = status;}
    public void setUpdateTime(Timestamp time){this.update_time = time;}

    @Override
    public boolean equals(Object other){
        if((other == null) || (other.getClass() != this.getClass())){
            return false;
        }
        Transactions tran = (Transactions) other;
        return (tran.getTransId() == this.trans_id) && Objects.equals(tran.getCartId(), this.cart_id)
        && Objects.equals(tran.getItemId(), this.item_id) && Objects.equals(tran.getTransStatus(), this.status)
        && Objects.equals(tran.getUpdateTime(), this.update_time);
    }
}