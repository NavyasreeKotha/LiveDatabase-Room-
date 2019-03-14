package com.example.navyasree.roomlivedata;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class ContactRepository {

    public static ContactDao myDao;

    LiveData<List<Contact>> getAllData;

    public ContactRepository(Context context){
        ContactDatabase contactDatabase=ContactDatabase.getInstance(context);
        myDao=contactDatabase.contactDao();
        getAllData=myDao.getAllContact();
    }
    LiveData<List<Contact>> getGetAllContacts(){
        return getAllData;
    }
    public void insert(Contact contact){
        new InsertTask().execute(contact);
    }
    public void update(Contact contact){
        new UpdateTask().execute(contact);
    }
    public void delete(Contact contact){
        new DeleteTask().execute(contact);
    }
    public void deleteAll(){
        new DeleteAllTask().execute();
    }


    public class InsertTask extends AsyncTask<Contact,Void,Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            myDao.insertContact(contacts[0]);
            return null;
        }
    }
    public class UpdateTask extends AsyncTask<Contact,Void,Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            myDao.updateContact(contacts[0]);
            return null;
        }
    }
    public class DeleteTask extends AsyncTask<Contact,Void,Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            myDao.deleteContact(contacts[0]);
            return null;
        }
    }
    public class DeleteAllTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            myDao.deleteAll();
            return null;
        }
    }
}