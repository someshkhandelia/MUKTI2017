package com.example.somesh1995.mukti2017_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Hackathon extends AppCompatActivity {

    Button call_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();


        call_button=(Button)findViewById(R.id.call_button);
        call_button.setText("Contact Arijit");
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcall = new Intent();
                intentcall.setAction(Intent.ACTION_DIAL);
                String phonenumber="+918697566869";
                intentcall.setData(Uri.parse("tel:" + phonenumber)); // set the Uri
                startActivity(intentcall);
            }
        });


    }
    /*protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }*/
}
