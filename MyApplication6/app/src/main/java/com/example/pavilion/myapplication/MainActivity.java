package com.example.pavilion.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1234;
    ImageButton Start;
    TextView Speech;
    Dialog match_text_dialog;
    ListView textlist;
    ArrayList<String> matches_text;
    String tes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start = (ImageButton) findViewById(R.id.start_reg);
        Speech = (TextView) findViewById(R.id.speech);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()) {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Connect to Internet", Toast.LENGTH_LONG).show();
                }
            }

        });


    }
    public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net = cm.getActiveNetworkInfo();
        if (net != null && net.isAvailable() && net.isConnected()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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


    private void call(String num) {
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
        try {
            startActivity(in);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "Your Activity is not found", Toast.LENGTH_SHORT).show();
        }
    }



    private String getContact(String spl) {
        String namecsv = "";
        String phonecsv = "";
        String namearray[];
        String phonearray[];
        int index=0;
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (phones.moveToNext()) {


            //Read Contact Name
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            //Read Phone Number
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            if (name != null) {
                namecsv += name + ",";
                phonecsv += phoneNumber + ",";
            }


        }
        phones.close();

        namearray = namecsv.split(",");
        phonearray = phonecsv.split(",");

        for (int i = 0; i < namearray.length; i++) {
            if (namearray[i].equalsIgnoreCase(spl)) {

                index = i;
            }
            else
            {
                //Toast.makeText(getApplicationContext(),"Contact not found", Toast.LENGTH_LONG).show();

            }
        }

        String no =phonearray[index];
        Toast.makeText(getApplicationContext(), no, Toast.LENGTH_LONG).show();


        return no;


    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {


            match_text_dialog = new Dialog(MainActivity.this);
            match_text_dialog.setContentView(R.layout.dialog_matches_frag);
            match_text_dialog.setTitle("Select Matching Text");
            textlist = (ListView)match_text_dialog.findViewById(R.id.list);
            matches_text = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ArrayAdapter<String> adapter =    new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, matches_text);
            textlist.setAdapter(adapter);
            textlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Speech.setText("You have said " + matches_text.get(position));
                    match_text_dialog.hide();
                    tes = matches_text.get(position);
                    if(tes.contains("call"))
                    {
                        String[] spl = tes.split("\\s+");
                        String num=getContact(spl[1]);
                        call(num);
                    }
                    if(tes.contains("message"))
                    {
                        String[] spl= tes.split("\\s+");
                        String num=getContact(spl[1]);
                        Intent intent= new Intent(getApplicationContext(),SecondActivity.class);
                        intent.putExtra("num", num);
                        startActivity(intent);

                                         }


                }
            });


            match_text_dialog.show();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
