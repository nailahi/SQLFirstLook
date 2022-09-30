
package com.example.sqlfirstlook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);
    EditText etSite;
    EditText etUser;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSite = findViewById(R.id.editTextTextPersonName);
        etUser = findViewById(R.id.editTextTextPersonName2);
        etPass = findViewById(R.id.editTextTextPersonName3);

    }

    public void onInsert(View view){
        SQLiteDatabase forms = helper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("Site", etSite.getText().toString());
        row.put("User", etUser.getText().toString());
        row.put("Password", etPass.getText().toString());
        forms.insert("formTable", null, row);
        forms.close();
        etUser.setText("");
        etPass.setText("");
    }

    public void onRetrieve(View view){
        SQLiteDatabase forms = helper.getReadableDatabase();
        String string = etSite.getText().toString();
       Cursor cursor = forms.rawQuery("select * from formTable where id = ?",
               new String[] {"user","string"});
        if(cursor.moveToFirst()){
            etUser.setText(etUser.toString());
            etPass.setText(etPass.toString());
        }else{
            etSite.setText("[null]");
        }
    }
}
