package com.example.navyasree.roomlivedata;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "ContactDetails")
public class Contact {
    @PrimaryKey@NonNull@ColumnInfo(name = "contact_id")
    String cid;
    @ColumnInfo(name="contact_name")
    String cname;
    @ColumnInfo(name = "contact_mail")
    String cmail;
    @ColumnInfo(name = "contact_number")
    String cnumber;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCmail() {
        return cmail;
    }

    public void setCmail(String cmail) {
        this.cmail = cmail;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }
}
