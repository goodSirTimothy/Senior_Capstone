package edu.rasmussen.capstone.senior_capstone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Omega on 12/9/2017.
 */

public class addlogin extends AppCompatActivity {
    EditText usernameET, passwordET;
    String usertype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addlogin);
        usernameET = (EditText) findViewById(R.id.username);
        passwordET = (EditText) findViewById(R.id.password);
    }

    public void submit (View view){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usertype = extras.getString("usertype");
        }
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String type = "login";
        loginadd backgroundWorker = new loginadd(this);
        backgroundWorker.execute(type, username, password, usertype);
        finish();
    }
}
