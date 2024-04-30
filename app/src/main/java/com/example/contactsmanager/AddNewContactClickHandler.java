package com.example.contactsmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;

    AppViewModel viewModel;

    public AddNewContactClickHandler(Contacts contact, Context context,AppViewModel viewModel) {
        this.contact = contact;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButtonClicked(View view){
        if (contact.getName()== null || contact.getNumber()== null){
            Toast.makeText(context, "Fields Can't be Empty", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(context, MainActivity.class);
            Contacts c = new Contacts(
                    contact.getName(),
                    contact.getNumber()
            );
            viewModel.addNewContact(c);

            context.startActivity(i);

        }


    }

}
