package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

//import kotlin.internal.IntrinsicConstEvaluation;

public class RegisterActivity extends AppCompatActivity {

    EditText dateOfBirth, username, password, confirmPassword, phoneNumber, email;
    Calendar calendar;
    Button btnRegister;
    TextView loginChangePage;
    Spinner country;
    String homeTown,gender;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;


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
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();
            }

            private void updateCalendar() {
                String format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);

                dateOfBirth.setText(sdf.format(calendar.getTime()));

            }
        };

        dateOfBirth.setOnClickListener(view -> new DatePickerDialog(RegisterActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show());

        loginChangePage = findViewById(R.id.textLogin);
        loginChangePage.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));


        username = findViewById(R.id.registerUsername);
        password = findViewById(R.id.registerPassword);
        confirmPassword = findViewById(R.id.registerConfirmPassword);
        email = findViewById(R.id.registerEmail);
        phoneNumber = findViewById(R.id.registerPhone);

        btnRegister = findViewById(R.id.btnRegister);

        CheckBox agree = findViewById(R.id.registerAgree);
        btnRegister = findViewById(R.id.btnRegister);
        country = findViewById(R.id.spinnerCountry);
        ArrayList<String> countryList = new ArrayList<>();
        countryList.add("Vietnam");
        countryList.add("England");
        countryList.add("Japan");
        countryList.add("China");
        countryList.add("Korea");
        countryList.add("France");
        countryList.add("Germany");
        countryList.add("Italy");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryList);
        country.setAdapter(adapter);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> country, View view, int i, long l) {
                homeTown = country.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(RegisterActivity.this, "Please select country", Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        selectedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
        gender = selectedRadioButton.getText().toString();




//        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
//
//                if (check) {
//                    btnRegister.setClickable(true);
//                    btnRegister.setBackgroundColor(Color.GREEN);
        btnRegister.setOnClickListener(view -> checkCredentials());
//                } else {
//                    btnRegister.setClickable(false);
//                    btnRegister.setBackgroundColor(Color.parseColor("#BFB3C1"));
//                    btnRegister.setOnClickListener(view -> Toast.makeText(RegisterActivity.this, "Check agree privacy", Toast.LENGTH_SHORT).show());
//
//
//                }
//            }
//        });
    }

    private void checkCredentials() {
        String inputUsername = username.getText().toString().trim();
        String inputEmail = email.getText().toString().trim();
        String inputPassword = password.getText().toString().trim();
        String inputConfirmPassword = confirmPassword.getText().toString().trim();
        String inputPhone = phoneNumber.getText().toString().trim();
        String inputDateOfBirth = dateOfBirth.getText().toString().trim();

        if (inputUsername.isEmpty() || inputUsername.length() < 7) {
            showError(username, "Username is not valid");
        } else if (!inputEmail.contains("@")) {
            showError(email, "Email is not valid");
        } else if (inputPassword.isEmpty() || inputPassword.length() < 6) {
            showError(password, "Password must be at least 6 characters");
        } else if (inputConfirmPassword.isEmpty() || !inputConfirmPassword.equals(inputPassword)) {
            showError(confirmPassword, "Password and confirm password do not match");
        } else if (inputPhone.isEmpty()) {
            showError(confirmPassword, "Password and confirm password do not match");
        } else if (inputDateOfBirth.isEmpty()) {
            showError(dateOfBirth, "Date of birth is empty");
        } else {
            Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();

            String string = "Username: " + inputUsername + "\n" + "Email: " + inputEmail + "\n" + "Password: " + inputPassword + "\n" + "Gender: " + gender + "\n" + "Phone: " + inputPhone + "\n" + "Date of birth: " + inputDateOfBirth + "\n" + "Home town: " + homeTown;

            Intent inputSuccess = new Intent(RegisterActivity.this, HomeActivity.class);

            inputSuccess.putExtra("userInfo", string);
            startActivity(inputSuccess);
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}