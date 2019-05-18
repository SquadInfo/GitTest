package com.example.foodplaza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.example.foodplaza.constant.APP_CONSTANT;
import com.example.foodplaza.networking.APIHandler;
import com.example.foodplaza.networking.APIManager;

import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    TextView message;
    Button loginButton;
    EditText userNameEdit, passwordEdit;
    final String uName = "abc", pwd = "abcd1234";
    boolean isUserLoggedIn = false;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(APP_CONSTANT.MY_PREFERENCE, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        message = findViewById(R.id.showMessage);
        userNameEdit = findViewById(R.id.userNameEditText);
        passwordEdit = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String userName = userNameEdit.getText().toString();
                    String password = passwordEdit.getText().toString();

                    String validData = validateData();

                    if (validData.equals("")) {
                        APIManager.getInstance().login(userName, password, new APIHandler() {
                            @Override
                            public void onSuccess(JSONObject response) {
                                editor.putBoolean(APP_CONSTANT.ISUSERLOGGEDIN, true);
                                editor.putString(APP_CONSTANT.USERNAME, userNameEdit.getText().toString());
                                editor.putString(APP_CONSTANT.PASSWORD, passwordEdit.getText().toString());
                                editor.commit();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(LoginActivity.this, "Failed to login", Toast.LENGTH_SHORT).show();
                            }
                        });
                        /*

                         */
                    } else {
                        Toast.makeText(LoginActivity.this, validateData(), Toast.LENGTH_SHORT).show();
                    }

                } catch (Throwable t) {
                    t.printStackTrace();
                }

            }
        });
    }

    private String validateData() {
        if (userNameEdit.getText().toString().isEmpty())
            return "Enter User Name";
        else if (passwordEdit.getText().toString().isEmpty())
            return "Password can't be empty";
        else if (passwordEdit.getText().toString().length() < 8)
            return "Password length must be 8 character";
        else
            return "";
    }
}