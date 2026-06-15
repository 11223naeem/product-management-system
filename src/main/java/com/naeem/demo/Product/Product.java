package com.naeem.demo.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   // ✅ PRIMARY KEY
    private String name;
     private String place;
      private String type;
       private int warrenty;

    public Product(String name, String place, String type, int warrenty) {
        this.name = name;
        this.place = place;
        this.type = type;
        this.warrenty = warrenty;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWarrenty() {
        return warrenty;
    }

    public void setWarrenty(int warrenty) {
        this.warrenty = warrenty;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", place=" + place + ", type=" + type + ", warrenty=" + warrenty + '}';
    }
       
       
     
    
    
}
