package com.example.navyasree.roomlivedata;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert
    public void insertContact(Contact contact);
    @Update
    public void updateContact(Contact contact);
    @Delete
    public void deleteContact(Contact contact);
    @Query("select * from ContactDetails")
    public LiveData<List<Contact>> getAllContact();
    @Query("delete from contactdetails")
    public void deleteAll();
}
