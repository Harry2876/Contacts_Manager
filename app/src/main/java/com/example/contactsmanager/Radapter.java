package com.example.contactsmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanager.databinding.ContactListBinding;

import java.util.ArrayList;

public class Radapter extends RecyclerView.Adapter<Radapter.ContactViewHolder> {

    private ArrayList<Contacts> contacts;

    public Radapter(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creating new viewHolders for items in recyclerView

        ContactListBinding contactListBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.contact_list,
                        parent,
                        false
                );
        return new ContactViewHolder(contactListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        /* Called by recyclerview when it needs to display or update an item
        at specific position in list or grid
         */
        Contacts currentContact= contacts.get(position);
        holder.contactListBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if (contacts != null){
            return contacts.size();} else{ return 0;}
    }

    //Notify Data Set changed


    public void setContacts(ArrayList<Contacts> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{

        private ContactListBinding contactListBinding;

        public ContactViewHolder(@NonNull ContactListBinding contactListBinding) {
            super(contactListBinding.getRoot());
            this.contactListBinding = contactListBinding;
        }
    }

}
