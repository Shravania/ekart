package com.niit.ekart.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Catagory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String Name;
    private String description;

    public Catagory(String Name, String description) {
        this.Name = Name;
       this.description = description;
    }
    

    public Catagory(int id, String Name, String description) {
        this.id = id;
        this.Name = Name;
        this.description = description;
    }

    public Catagory(int id) {
        this.id = id;
    }

    public Catagory() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
