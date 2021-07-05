package com.showroom.skin.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patterns")
public class Patterns {
    private @Id int pattern_id;
    private String pattern_name;

    public Patterns(){}
    
    public Patterns(int pattern_id, String pattern_name){
        this.pattern_id = pattern_id;
        this.pattern_name = pattern_name;
    }

    public int getPatternId(){return this.pattern_id;}
    public String getPatternName(){return this.pattern_name;}

    public void setPatternId(int pattern_id){this.pattern_id = pattern_id;}
    public void setPatternName(String pattern_name){this.pattern_name = pattern_name;}

    @Override
    public boolean equals(Object other){
        if((other==null) || (other.getClass() != this.getClass())){
            return false;
        }
        Patterns patt = (Patterns) other;
        return (patt.getPatternId() == this.pattern_id) && Objects.equals(patt.getPatternName(), this.pattern_name);
    }
}
