package com.example.authorizationsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText editTextStr, editTextPas;
    Button btnSave, btnLoad;
    TextView viewLogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStr = (EditText) findViewById(R.id.editTextStr);
        editTextPas = (EditText) findViewById(R.id.editTextPas);

        btnSave = (Button) findViewById(R.id.save);
        btnSave.setOnClickListener((View.OnClickListener) this);

        btnLoad = (Button) findViewById(R.id.toRegister);
        btnLoad.setOnClickListener((View.OnClickListener) this);

        viewLogin = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                loadData(editTextStr.getText().toString(), editTextPas.getText().toString()); break;
            case R.id.toRegister:
                Intent intent = new Intent(this, Registration.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    void loadData(String login, String password) {
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String savedLogin = sharedPreferences.getString(login, "nope");
        viewLogin.setText(savedLogin.equals(password)? "welcome":"something wrong");
        //Toast.makeText(this, savedLogin == password? "Welcome": "Wrong", Toast.LENGTH_SHORT).show();
    }
}