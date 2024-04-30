package com.example.contactsmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigInteger;

@Entity(tableName = "contacts_table")
public class Contacts {

    @ColumnInfo(name = "contacts_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "contacts_name")
    private String name;

    @ColumnInfo(name = "contacts_number")
    private String number;

    //Creating 2 constructor one having all thing and empty to avoid null pointer exception
    public Contacts( String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contacts() {
    }

    //Creating getters and setters for all elements

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
