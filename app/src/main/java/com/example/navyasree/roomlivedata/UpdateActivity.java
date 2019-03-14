package com.example.navyasree.roomlivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText cuid,cuname,cumail,cunumber;
    ContactViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        cuid=findViewById(R.id.uid);
        cuname=findViewById(R.id.uname);
        cumail=findViewById(R.id.umail);
        cunumber=findViewById(R.id.unumber);
        String[] s=getIntent().getStringArrayExtra("data");
        cuid.setText(s[0]);
        cuname.setText(s[1]);
        cumail.setText(s[2]);
        cunumber.setText(s[3]);
        viewModel= ViewModelProviders.of(this).get(ContactViewModel.class);
    }

    public void update(View view) {
        Contact contact=new Contact();
        contact.setCid(cuid.getText().toString());
        contact.setCname(cuname.getText().toString());
        contact.setCmail(cumail.getText().toString());
        contact.setCnumber(cunumber.getText().toString());
        viewModel.updateData(contact);
        finish();
    }
}
