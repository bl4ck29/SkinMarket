package com.showroom.skin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {
    // @Id
    // @GenericGenerator(name = "item_id", strategy = "com.showroom.skin.function.ItemIdIdGenerator")
    // @GeneratedValue(generator = "item_id")  
    // @Column(name="item_id")
    // private int item_id;

    private @Id int item_id;
    private String gun_id, pattern_id, author, item_image;

    public Items(){}

    public Items(int item_id, String gun_id, String pattern_id, String author, String item_image){
        this.item_id = item_id;
        this.gun_id = gun_id;
        this.pattern_id = pattern_id;
        this.author = author;
        this.item_image = item_image;
    }

    public int getItemId(){ return this.item_id;}
    public String getGunId(){ return this.gun_id;}
    public String getPatternId(){ return this.pattern_id;}
    public String getAuthor(){ return this.author;}
    public String getItemImage(){ return this.item_image;}

    public void setItemId(int item_id){this.item_id = item_id;}
    public void setGunId(String gun_id){this.gun_id = gun_id;}
    public void setPatternId(String pattern_id){this.pattern_id = pattern_id;}
    public void setAuthor(String author){this.author = author;}
    public void setItemImage(String item_image){this.item_image = item_image;}

    @Override
    public boolean equals(Object other){
        if ((other == null) || (other.getClass() != this.getClass())){
            return false;
        }
        Items itm = (Items) other;
        return (itm.getItemId() == this.item_id) && Objects.equals(itm.getGunId(), this.gun_id) 
        && Objects.equals(itm.getPatternId(), this.pattern_id) && Objects.equals(itm.getAuthor(), this.author);
    }
}
