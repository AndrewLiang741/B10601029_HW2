package com.example.android.waitlist;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.waitlist.data.WaitlistContract;
import com.example.android.waitlist.data.WaitlistDbHelper;

public class AddActivity extends AppCompatActivity {

    private EditText mNewGuestNameEditText;
    private EditText mNewPartySizeEditText;
    private Button Button_add;
    private Button Button_back;
    private String[] array =new String[2] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mNewGuestNameEditText = (EditText) findViewById(R.id.person_name_edit_text);
        mNewPartySizeEditText = (EditText) findViewById(R.id.party_count_edit_text);
        Button_add = (Button) findViewById(R.id.add_to_waitlist_button);
        Button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                array[0] = mNewGuestNameEditText.getText().toString();
                array[1] = mNewPartySizeEditText.getText().toString();
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArray("name", array);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Button_back = (Button) findViewById(R.id.cancel_to_waitlist_button);
        Button_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Context context = AddActivity.this;
                Class destinationActivity = MainActivity.class;
                Intent intent = new Intent(context, destinationActivity);
                startActivity(intent);
            }
        });
    }



}
