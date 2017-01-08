package com.example.somesh1995.mukti2017_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int k;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String s1=null;
    int key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
      /*  uiOptions=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        key=0;
        key=preferences.getInt("current", -1);
        s1=preferences.getString("cu",null);
        if(s1==null){
            Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
            editor.putInt("current", 0);
            editor.putString("cu","Arpit");
            editor.commit();
        }


        startService(new Intent(getBaseContext(), Notify.class));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_main);


            }
        }, 1000);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(MainActivity.this,ScreenSlidePagerActivity.class);
                startActivity(i);
            }
        }, 5000);
    }

    protected void onResume() {
        super.onResume();


    }


}
