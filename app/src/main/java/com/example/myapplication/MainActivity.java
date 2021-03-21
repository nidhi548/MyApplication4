package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextName;
    Button buttonSet, buttonGet;
    TextView textViewName;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        editTextName = findViewById(R.id.edit_text_name);
        buttonGet = findViewById(R.id.button_get);
        buttonSet = findViewById(R.id.button_set);
        textViewName = findViewById(R.id.text_view_name);

        buttonSet.setOnClickListener(this);
        buttonGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_get:
                sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("NAME", null);
                textViewName.setText(name);
                break;
            case R.id.button_set:
                String name2 = editTextName.getText().toString();

                sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("NAME", name2);
                editor.commit();
                editTextName.setText("");
                Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}