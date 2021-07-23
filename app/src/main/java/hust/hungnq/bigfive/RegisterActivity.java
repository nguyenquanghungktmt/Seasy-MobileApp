package hust.hungnq.bigfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class RegisterActivity extends AppCompatActivity {
    private Context context;

    private EditText editFullName;
    private EditText editUserName;
    private EditText editPhoneNumber;
    private EditText editAddress;
    private EditText editPassword;
    private EditText editRePassword;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        context = this;

        connectView();
    }

    private void connectView() {
        editFullName = findViewById(R.id.editFullName);
        editUserName = findViewById(R.id.editUserName);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        editAddress = findViewById(R.id.editAddress);
        editPassword = findViewById(R.id.editPassword);
        editRePassword = findViewById(R.id.editRePassword);

        progressBar = findViewById(R.id.progressLogin);

    }

    private void showProgress(boolean isShow) {
        progressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
        findViewById(R.id.registerForm).setVisibility(!isShow ? View.VISIBLE : View.GONE);
    }

    public void confirmRegister(View view) {
        boolean error = false;

        showProgress(true);
        // when process we must have sometime

        // get data
        String fullName = editFullName.getText().toString().trim();
        String userName = editUserName.getText().toString().trim();
        String phoneNumber = editPhoneNumber.getText().toString().trim();
        String address = editAddress.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String rePassword = editRePassword.getText().toString().trim();

        // fullName empty
        if (TextUtils.isEmpty(fullName)) {
            editFullName.requestFocus();
            editFullName.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // user name empty
        if (TextUtils.isEmpty(userName)) {
            editUserName.requestFocus();
            editUserName.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // phone number empty
        if (TextUtils.isEmpty(phoneNumber)) {
            editPhoneNumber.requestFocus();
            editPhoneNumber.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // address empty
        if (TextUtils.isEmpty(address)) {
            editAddress.requestFocus();
            editAddress.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // password empty
        if (TextUtils.isEmpty(password)) {
            editPassword.requestFocus();
            editPassword.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // re password empty
        if (TextUtils.isEmpty(rePassword)) {
            editRePassword.requestFocus();
            editRePassword.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        if (!password.equals(rePassword)) {
            editRePassword.requestFocus();
            editRePassword.setError(context.getResources().getString(R.string.error_password_not_match));
            error = true;
        }

        // all data is ok
        showProgress(false);

        if (!error) {
            // create intent to send data back Login Activity
            Intent intent = new Intent();

            // send data
            intent.putExtra(LoginActivity.KEY_USER_FROM_REGISTER, userName);

            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void cancelRegister(View view) {
        finish();
    }

    public void backToLogin(View view) {
        finish();
    }
}