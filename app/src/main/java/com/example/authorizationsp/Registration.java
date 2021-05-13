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

public class Registration extends Activity implements View.OnClickListener {
    EditText editNewLogin, editNewPassword;
    Button btnReg, btnBack;
    TextView viewInfo;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editNewLogin = (EditText) findViewById(R.id.inputLogin);
        editNewPassword = (EditText) findViewById(R.id.inputPassword);

        btnReg = (Button) findViewById(R.id.Register);
        btnReg.setOnClickListener((View.OnClickListener) this);

        btnBack = (Button) findViewById(R.id.Back);
        btnBack.setOnClickListener((View.OnClickListener) this);

        viewInfo = (TextView) findViewById(R.id.textViewInfo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Register:
                saveData();
                viewInfo.setText("registrated successful");
                break;
            case R.id.Back:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
    void saveData(){
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(editNewLogin.getText().toString(), editNewPassword.getText().toString());
        editor.commit();
    }

}