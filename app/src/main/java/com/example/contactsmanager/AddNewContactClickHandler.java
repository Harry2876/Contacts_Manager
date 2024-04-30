package com.example.contactsmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;

    public AddNewContactClickHandler(Contacts contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    public void onSubmitButtonClicked(View view){
        if (contact.getName()== null || contact.getNumber()== null){
            Toast.makeText(context, "Fields Can't be Empty", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("Name",contact.getName());
            i.putExtra("Number", contact.getName());
            context.startActivity(i);

        }


    }

}
