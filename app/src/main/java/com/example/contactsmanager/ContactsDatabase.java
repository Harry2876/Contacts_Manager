package com.example.contactsmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contacts.class},version = 1)
public abstract class ContactsDatabase extends RoomDatabase {

    //Linking With DAO
    public abstract ContactDAO getContactDAO();

    //Creating instance of database using singleton design pattern
    private static ContactsDatabase dbInstance;

    //Create instance to prevent Memory Leaks
    public static  synchronized ContactsDatabase getInstance(Context context){
        if (dbInstance == null){
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactsDatabase.class,
                    "contacts_db").
                    fallbackToDestructiveMigration()
                    .build();

        }
        return dbInstance;
    }

}
