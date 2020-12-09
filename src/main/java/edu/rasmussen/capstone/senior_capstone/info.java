package edu.rasmussen.capstone.senior_capstone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Omega on 12/7/2017.
 */

public class info extends AppCompatActivity {
    String usertype = "", str;
    int limit = 0;
    Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usertype = extras.getString("usertype");
            limit = extras.getInt("limit");
        }
        if (limit == 0) {
            Query getQuery = new Query(this);
            getQuery.execute("info", usertype);
            finish();
        }

        Bundle queryReturn = getIntent().getExtras();
        if (extras != null) {
            str = queryReturn.getString("output");
        }

        TextView view = (TextView) findViewById(R.id.textView);
        view.setText(str);


        /*
        for (int i = 0, j = 0; i < strArray.size() && j < strArray.size()/7;) {
            row = new TableRow(info.this);
            textViewArray[j] = new TextView(info.this);
            if (input1.size() > i) {
                if ((input1.get(i) != null)) {
                    txtcol1.setText(input1.get(i));
                    i++;
                }
            } else {
                txtcol1.setText("");
            }
            row.addView(txtcol1);
            txtcol2 = new TextView(info.this);
            if ((input2.size() > j)) {
                if (input2.get(j) != null) {
                    txtcol2.setText(input2.get(j));
                    j++;
                }
            } else {
                txtcol2.setText("");
            }
            this.row.addView(txtcol2);
            inflate.addView(row);
        }
        //TextView tv1 = (TextView)findViewById(R.id.textView);
        //tv1.setText(str + "\n" + value); */
    }
    public void addEmp (View view){
        Intent add = new Intent(this, addemp.class);
        add.putExtra("usertype", usertype);
        startActivity(add);
        finish();
    }
    public void deleteEmp (View view){
        Intent delete = new Intent(this, deleteemp.class);
        delete.putExtra("usertype", usertype);
        delete.putExtra("limit", 0);
        startActivity(delete);
        finish();

    }
    public void addLog (View view){
        Intent add = new Intent(this, addlogin.class);
        add.putExtra("usertype", usertype);
        startActivity(add);
        finish();

    }
    public void deleteLog (View view){
        Intent delete = new Intent(this, deletelogin.class);
        delete.putExtra("usertype", usertype);
        delete.putExtra("limit", 0);
        startActivity(delete);
        finish();

    }
    public void serach (View view){
        Intent search = new Intent(this, search.class);
        search.putExtra("usertype", usertype);
        search.putExtra("limit", 0);
        startActivity(search);
        finish();

    }
}
