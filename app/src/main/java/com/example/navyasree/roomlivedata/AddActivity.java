package com.example.navyasree.roomlivedata;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText iid,iname,imail,inumber;
    ContactViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        iid=findViewById(R.id.aid);
        iname=findViewById(R.id.aname);
        imail=findViewById(R.id.amail);
        inumber=findViewById(R.id.anumber);
        viewModel= ViewModelProviders.of(this).get(ContactViewModel.class);
    }

    public void save(View view) {
        Contact contact=new Contact();
        contact.setCid(iid.getText().toString());
        contact.setCname(iname.getText().toString());
        contact.setCmail(imail.getText().toString());
        contact.setCnumber(inumber.getText().toString());
        viewModel.insertData(contact);
        finish();
    }
}
