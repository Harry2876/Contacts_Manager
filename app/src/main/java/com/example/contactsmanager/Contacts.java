package com.example.contactsmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class Contacts {

    @ColumnInfo(name = "contacts_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "contacts_name")
    private String name;

    @ColumnInfo(name = "contacts_number")
    private int number;

    //Creating 2 constructor one having all thing and empty to avoid null pointer exception
    public Contacts(int id, String name, int number) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
