package edu.rasmussen.capstone.senior_capstone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Omega on 12/9/2017.
 */

public class addemp extends AppCompatActivity {
    EditText fnameET, lnameET, stateET, addressET, phoneET;
    String usertype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addemp);
        fnameET = (EditText) findViewById(R.id.first_name);
        lnameET = (EditText) findViewById(R.id.last_name);
        stateET = (EditText) findViewById(R.id.state);
        addressET = (EditText) findViewById(R.id.address);
        phoneET = (EditText) findViewById(R.id.phone);
    }

    public void submit (View view){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usertype = extras.getString("usertype");
        }
        String fname = fnameET.getText().toString();
        String lname = lnameET.getText().toString();
        String state = stateET.getText().toString();
        String address = addressET.getText().toString();
        String phone = phoneET.getText().toString();
        String type = "login";
        empadd backgroundWorker = new empadd(this);
        backgroundWorker.execute(type, fname, lname, state, address, phone, usertype);
        finish();
    }
}
