package hust.hungnq.bigfive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ScanFragment extends Fragment {

    View view;

    Context context;

    Button mScanNow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_scan, container, false);

        context = view.getContext();

        // handle onclick event
        mScanNow = view.findViewById(R.id.btn_scan_now);
        mScanNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickScanNow();
            }
        });

        return view;
    }

    private void onClickScanNow() {
        Toast.makeText(context, "Scan Now", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, QRCodeScanner.class);
        context.startActivity(intent);
    }
}