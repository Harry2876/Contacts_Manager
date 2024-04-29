package com.example.contactsmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

      /* If you need to use your context inside you view model You should
         use AndroidViewModel because it contains the application context. */

    private Repository myRepository;

    //Live Data
    private LiveData<List<Contacts>> allContacts;
    public AppViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    //Getting AllContacts
    public LiveData<List<Contacts>> getAllContacts() {
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contacts contact){
        myRepository.addContact(contact);
    }

    public void deleteContact(Contacts contact){
        myRepository.deleteContact(contact);
    }



}
