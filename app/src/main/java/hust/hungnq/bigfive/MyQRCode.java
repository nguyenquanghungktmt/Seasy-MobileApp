package hust.hungnq.bigfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyQRCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_qr_code);

        this.setFinishOnTouchOutside(true);
    }
}