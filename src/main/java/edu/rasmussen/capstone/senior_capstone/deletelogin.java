package edu.rasmussen.capstone.senior_capstone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Omega on 12/9/2017.
 */

public class deletelogin extends AppCompatActivity {
    EditText idET;
    String usertype, str;
    int limit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletelogin);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usertype = extras.getString("usertype");
            limit = extras.getInt("limit");
        }
        if (limit == 0) {
            deleteQuery getQuery = new deleteQuery(this);
            getQuery.execute("info", usertype);
            finish();
        }

        Bundle queryReturn = getIntent().getExtras();
        if (extras != null) {
            str = queryReturn.getString("output");
        }

        TextView view = (TextView) findViewById(R.id.textView);
        view.setText(str);

        idET = (EditText) findViewById(R.id.ID);
    }

    public void delete (View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usertype = extras.getString("usertype");
        }
        String ID = idET.getText().toString();
        String type = "login";
        logindelete backgroundWorker = new logindelete(this);
        backgroundWorker.execute(type, ID, usertype);
        finish();
    }
}