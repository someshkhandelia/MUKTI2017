package com.example.somesh1995.mukti2017_2;

/**
 * Created by somesh1995 on 1/8/2017.
 */
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Updates extends AppCompatActivity  {

    ArrayList<String> limits = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showupdates);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       // toolbar.setLogo(R.drawable.home3);
       // toolbar.setTitle("MUKTI 2017");

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.button_material_dark  ));




        new PollTask().execute();


    }



    private class PollTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... args) {
            // do stuff!
            String title = null;


            try {
                // Create a URL for the desired page
                URL updateURL = new URL("http://172.16.45.155:8000/notif");

                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(updateURL.openStream()));
                StringBuilder total = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    total.append(line).append("\n");
                }
                title = total.toString();


                in.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return title;

        }


        @Override
        protected void onPostExecute(String title) {
            JSONArray jarray=null;
            JSONObject g1=null;
            JSONObject f=null;
            String update=null;
            if (title == null) {

                limits.add("Unable to Fetch Updates! Please check Internet Connection ");
                //Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list, limits);

                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);


            } else {


                try {
                    jarray = new JSONArray(title);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i=0;i<jarray.length();i++)
                {
                    try {
                        g1=jarray.getJSONObject(i);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        f=g1.getJSONObject("fields");
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        update=f.getString("text");
                    } catch (JSONException h) {
                        h.printStackTrace();
                    }

                    limits.add(update);
                }

               /* for(int j=0;j<;j++)
                {
                    Toast.makeText(getApplicationContext(),post[j],Toast.LENGTH_LONG).show();
                }*/
                ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list, limits);

                ListView listView = (ListView) findViewById(R.id.mobile_list);
                listView.setAdapter(adapter);


            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent myintent = new Intent(Updates.this,ScreenSlidePagerActivity.class);
        startActivity(myintent);
        finish();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
