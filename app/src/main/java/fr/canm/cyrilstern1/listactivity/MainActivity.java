package fr.canm.cyrilstern1.listactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SimpleAdapter rowAdapteur;
    private static String EXTRA_MESSAGE = "message de l'autre application";
    private ArrayList<String> tabss = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);
        ContactService tabContact = new ContactService();
        tabss.addAll(tabContact.getContact(this));

        rowAdapteur = new SimpleAdapter(
                this.getBaseContext(),
                tabContact.getContact(this.getBaseContext()),
                R.layout.row,
                new String[]{"img","name","phone"},
                new int[]{R.id.avatar,R.id.name,R.id.phone}
        );

        list.setAdapter(rowAdapteur);
        final Toast toast = Toast.makeText(this, "etvoila", Toast.LENGTH_SHORT);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                ContactService tabContact = new ContactService();
                intent.putExtra("intent", tabContact.getItemValues(parent.getContext(),position));
                toast.show();
                startActivity(intent);

            }

        });
    }
}
