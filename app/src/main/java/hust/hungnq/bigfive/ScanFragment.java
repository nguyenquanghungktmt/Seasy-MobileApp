package hust.hungnq.bigfive;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ScanFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("myTag", "onAttach");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("myTag", "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myTag", "onDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("myTag", "onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("myTag", "onStart");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("myTag", "onStop");
    }
}