package com.example.contactsmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    //Available Data Sources
    // - ROOM Database

    private final ContactDAO contactDAO;

    ExecutorService executor;
    Handler handler;


    public Repository(Application application) {

        //Connect database and DAO in Repository
        ContactsDatabase contactsDatabase = ContactsDatabase.getInstance(application);
        this.contactDAO = contactsDatabase.getContactDAO();

        //Used for background database operations
        executor = Executors.newSingleThreadExecutor();

        //Used for updating the ui
        handler = new Handler(Looper.getMainLooper());
    }

    //Executing all methods in DAO
    public void addContact(Contacts contact){

        //Runnable: Executing tasks on a single thread
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });
    }

    public void deleteContact(Contacts contact){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contacts>> getAllContacts(){
        return contactDAO.getAllContacts();
    }


}
