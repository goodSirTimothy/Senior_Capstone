package edu.rasmussen.capstone.senior_capstone;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Omega on 12/9/2017.
 */

public class search extends AppCompatActivity {
    private String[] arraySpinner;
    String usertype = "", str;
    int limit = 0;
    Context context;
    TextView view;
    Spinner spin;
    EditText input;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        // spinner
        this.arraySpinner = new String[] {
                "ID", "First Name", "Last Name", "State", "Address", "Phone Number"
        };
        spin = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        spin.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usertype = extras.getString("usertype");
            limit = extras.getInt("limit");
        }
        if (limit == 0) {
            searcgQuery getQuery = new searcgQuery(this);
            getQuery.execute("info", usertype);
            finish();
        }

        Bundle queryReturn = getIntent().getExtras();
        if (extras != null) {
            str = queryReturn.getString("output");
        }

        input = (EditText)findViewById(R.id.editText);

        view = (TextView) findViewById(R.id.textView);
        view.setText(str);
    }

    public void submit (View view){
        String searchInput = input.getText().toString();
        String textspin = spin.getSelectedItem().toString();
        searchFull full = new searchFull(this);
        full.execute("info", usertype, textspin, searchInput);
        finish();

    }

}
