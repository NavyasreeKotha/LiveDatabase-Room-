package com.example.navyasree.roomlivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Update;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    Context context;
    List<Contact> contacts;
    ContactViewModel contactViewModel;
    public ContactAdapter(MainActivity mainActivity, List<Contact> contacts) {
        this.context=mainActivity;
        this.contacts=contacts;
    }

    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rowdesign,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactAdapter.MyViewHolder holder, final int position) {
            Contact model=contacts.get(position);
            holder.tid.setText(model.cid);
            holder.tname.setText(model.cname);
            holder.tmail.setText(model.cmail);
            holder.tnumber.setText(model.cnumber);
            holder.uiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] contact=new String[4];
                    contact[0] = contacts.get(position).getCid();
                    contact[1] = contacts.get(position).getCname();
                    contact[2] = contacts.get(position).getCmail();
                    contact[3] = contacts.get(position).getCnumber();
                    Intent i= new Intent(context,UpdateActivity.class);
                        i.putExtra("data",contact);
                        context.startActivity(i);
                }
            });
            holder.div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contact contact=new Contact();
                    contact.setCid(holder.tid.getText().toString());
                    contactViewModel= ViewModelProviders.of((FragmentActivity) context).get(ContactViewModel.class);
                    contactViewModel.deleteData(contact);
                }
            });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tid,tname,tmail,tnumber;
            ImageView uiv,div;

        public MyViewHolder(View itemView) {
            super(itemView);
            tid=itemView.findViewById(R.id.rid);
            tname=itemView.findViewById(R.id.rname);
            tmail=itemView.findViewById(R.id.rmail);
            tnumber=itemView.findViewById(R.id.rnumber);
            uiv=itemView.findViewById(R.id.ruimage);
            div=itemView.findViewById(R.id.rdimage);
        }
    }
}
