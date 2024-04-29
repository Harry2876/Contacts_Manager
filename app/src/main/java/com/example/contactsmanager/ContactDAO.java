package com.example.contactsmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDAO {

    //Adding Annotation for inserting table for database
    @Insert
    void insert(Contacts contact);

    @Delete
    void delete(Contacts contact);

    //Creating Custom Query
    @Query("SELECT * FROM contacts_table")
    LiveData<List<Contacts>> getAllContacts();

}
