package edu.rasmussen.capstone.senior_capstone;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Omega on 12/9/2017.
 */

public class logindelete extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    String usertype;
    logindelete (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.0.127:1234/logindelete.php";
        if(type.equals("login")) {
            try {
                String id = params[1];
                usertype = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("submit","UTF-8")+"="+URLEncoder.encode("Send","UTF-8")+"&"
                        +URLEncoder.encode("ID","UTF-8")+"="+URLEncoder.encode(id,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Connection Error");
    }

    String output;
    @Override
    public void onPostExecute(String result) {

        //call info.xml.
        if (result != ""){
            Toast.makeText(context, "Employee Deleted... D:", Toast.LENGTH_SHORT).show();
            Intent info = new Intent(context.getApplicationContext(), info.class);
            info.putExtra("usertype", usertype);
            info.putExtra("limit", 0);
            context.startActivity(info);
        } else {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Error Reports");
            alertDialog.setMessage("Could not connect properly");
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}