package fr.canm.cyrilstern1.listactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView thename = (TextView)findViewById(R.id.thename);
        TextView thephone = (TextView)findViewById(R.id.thephone);
        ImageView avatar = (ImageView)findViewById(R.id.avatarBig);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String []words = intent.getStringArrayExtra("intent");
        thename.setText(words[0]);
        avatar.setImageURI(Uri.parse(words[2]));
        thephone.setText(words[1]);



    }

}
