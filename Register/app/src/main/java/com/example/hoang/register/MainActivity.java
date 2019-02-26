package com.example.hoang.register;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import java.text.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText firstName, lastName, birthday, address, email;
    private Button selected, register;
    private RadioButton male, female;
    private int mYear, mMonth, mDay;
    private CheckBox check;
    private String text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        birthday = (EditText) findViewById(R.id.birthday);
        address = (EditText) findViewById(R.id.address);
        email = (EditText) findViewById(R.id.email);
        selected = (Button) findViewById(R.id.selected);
        register = (Button) findViewById(R.id.register);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        check = (CheckBox) findViewById(R.id.check);

        selected.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == selected) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            birthday.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v==register) {
            text = "";
            if(firstName.getText().toString().length() == 0) text += "Ban dien thieu FirstName\n";
            if(lastName.getText().toString().length() == 0) text += "Ban dien thieu Last Name\n ";
            if(!male.isChecked() && !female.isChecked()) text += "Ban chua tick Gender\n ";
            if(birthday.getText().toString().length() == 0) text += "Ban chua dien Birthday\n ";
            if(address.getText().toString().length() == 0) text += "Ban chua dien Address\n ";
            if(email.getText().toString().length() == 0)
                text += "Ban chua dien Email\n ";
            else if (email.getText().toString().contains("@")==false)
                text += "Ban dien sai cu phap Email\n";
            if(check.isChecked() == false) text += "You don't agree to Terms of Use. ";
            if (text.equals(""))
                text = "Register thanh cong";
            Toast.makeText(this,text,Toast.LENGTH_LONG).show();
        }
    }
}