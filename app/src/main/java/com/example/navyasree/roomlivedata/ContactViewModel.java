package com.example.navyasree.roomlivedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    public ContactRepository contactRepository;

    public LiveData<List<Contact>> getAllContactsData;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        contactRepository=new ContactRepository(application);
        getAllContactsData=contactRepository.getGetAllContacts();

    }
    public void insertData(Contact contact){
        contactRepository.insert(contact);
    }
    public void updateData(Contact contact){
        contactRepository.update(contact);
    }
    public void deleteData(Contact contact){
        contactRepository.delete(contact);
    }
    public void deleteAllData(){
        contactRepository.deleteAll();
    }

    public LiveData<List<Contact>> getGetAllContactsData() {
        return getAllContactsData;
    }
}
