package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    EditText dateOfBirth, username, password, confirmPassword, phoneNumber, email;
    Calendar calendar;
    Button btnRegister;
    TextView loginChangePage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Show date picker
        dateOfBirth = findViewById(R.id.registerDoB);
        calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateCalendar();
            }

            private void updateCalendar() {
                String format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

                dateOfBirth.setText(sdf.format(calendar.getTime()));

            }
        };

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(RegisterActivity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        loginChangePage = findViewById(R.id.textLogin);

        loginChangePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });


//        agree = findViewById(R.id.registerAgree);
//        btnRegister = findViewById(R.id.btnRegister);
//        radio = findViewById(R.id.radioGroup);
//        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
//                if (check) {
//                    btnRegister.setVisibility(View.VISIBLE);
//                    radio.setVisibility(View.GONE);
//                } else {
//                    btnRegister.setVisibility(View.GONE);
//                    radio.setVisibility(View.VISIBLE);
//                }
//            }
//        });

        username = findViewById(R.id.registerUsername);
        password = findViewById(R.id.registerPassword);
        confirmPassword = findViewById(R.id.registerConfirmPassword);
        email = findViewById(R.id.registerEmail);
        phoneNumber = findViewById(R.id.registerPhone);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> checkCredentials());

    }

    private void checkCredentials() {
        String inputUsername = username.getText().toString().trim();
        String inputEmail = email.getText().toString().trim();
        String inputPassword = password.getText().toString().trim();
        String inputConfirmPassword = confirmPassword.getText().toString().trim();
        String inputPhone = phoneNumber.getText().toString().trim();

        if (inputUsername.isEmpty() || inputUsername.length() < 7) {
            showError(username, "Username is not valid");
        } else if (!inputEmail.contains("@")) {
            showError(email, "Email is not valid");
        } else if (inputPassword.isEmpty() || inputPassword.length() < 6) {
            showError(password, "Password must be at least 6 characters");
        } else if (inputConfirmPassword.isEmpty() || !inputConfirmPassword.equals(inputPassword)) {
            showError(confirmPassword, "Password and confirm password do not match");
        }else if (inputPhone.isEmpty()){
            showError(confirmPassword, "Password and confirm password do not match");
        }
        else {
            Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}