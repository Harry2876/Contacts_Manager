package com.example.contactsmanager;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data Source
    private ContactsDatabase contactsDatabase;
    private ArrayList<Contacts> contacts = new ArrayList<>();

    //Adapters
    private Radapter rAdapter;

    //Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Data Binding
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        handler = new MainActivityClickHandler(this);

        mainBinding.setClickHandler(handler);

        //Recycler View
        RecyclerView recyclerView = mainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //DataBase
        contactsDatabase = ContactsDatabase.getInstance(this);

        //View Model
        AppViewModel viewModel = new ViewModelProvider(this).get(AppViewModel.class);

        //Inserting a contact for testing
        Contacts c1 = new Contacts(
                "User",
                "1234567890");

        //Load data from room db
        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contacts.clear();
                for( Contacts c: contacts){
                    Log.v("TAGY",c.getName());
                    contacts.add(c);
                }

                rAdapter.notifyDataSetChanged();
            }
        });

        //Adapters
        rAdapter = new Radapter(contacts);

        //Linking recycler view with the adapter
        recyclerView.setAdapter(rAdapter);


    }
}