package fr.canm.cyrilstern1.listactivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cyrilstern1 on 20/03/2016.
 */
public class ContactService {
    private String name = new String();
    private String phone = new String();
    private String UriPhoto = new String();
    private String[] tab = new String[3];
    private ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
    private HashMap<String, String> row;
    private Integer i = 0;

    public ArrayList getContact(Context context) {

        ContentResolver cr = context.getContentResolver();
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);

        if (cur != null && cur.getCount() > 0) {
            cur.moveToFirst();
            while (cur.moveToNext()) {

                 phone = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                 name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String picture = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                if(picture != null){
                    UriPhoto=picture;
                }
                else{

                    UriPhoto = String.valueOf(R.drawable.defaultavatar);
                }
                row = new HashMap<String, String>();
                row.put("name", name);
                row.put("phone", phone);
                row.put("img", UriPhoto);
                listItem.add(row);
            }
            cur.close();

        }
        return listItem;
    }

    public String[] getItemValues(Context context, Integer i) {

        HashMap<String, String> rowItem;
        String[] value = new String [3];
        ContentResolver cr = context.getContentResolver();
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);

        if (cur != null && cur.getCount() > 0) {
            cur.moveToFirst();
            while (cur.moveToNext()) {

                phone = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                String picture = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
                if(picture != null){
                    UriPhoto = picture;
                }
                else{UriPhoto = String.valueOf(R.drawable.defaultavatar);}
                row = new HashMap<String, String>();
                row.put("name", name);
                row.put("phone", phone);
                row.put("img", UriPhoto);
                listItem.add(row);
            }
            cur.close();


            rowItem = listItem.get(i);
            value[0] = rowItem.get("name");
            value[1] = rowItem.get("phone");
            value[2] = rowItem.get("img");


        }
            return value;


    }
}
