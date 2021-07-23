package hust.hungnq.bigfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText editPhoneNumberForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        editPhoneNumberForgot = findViewById(R.id.editPhoneNumberForgot);
    }

    public void continueForgotPass(View view) {
//        boolean error = false;
//
//        // get data
//        String phoneNumForgot = editPhoneNumberForgot.getText().toString().trim();
//
//        // password empty
//        if (TextUtils.isEmpty(phoneNumForgot)) {
//            editPhoneNumberForgot.requestFocus();
//            editPhoneNumberForgot.setError(this.getResources().getString(R.string.error_field_required));
//            error = true;
//        }
//
//        if (!error) {
//            Toast.makeText(this, "Forgot Password \n" + "You typed " + phoneNumForgot, Toast.LENGTH_SHORT).show();
//        }

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    public void backToLogin(View view) {
        finish();
    }
}