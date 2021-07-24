package hust.hungnq.bigfive;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    View view;

    Context context;

    ImageButton btnPayment, btnPurchase, btnExchange, btnLocation, btnHelp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        context = view.getContext();

        // handle onclick payment button
        btnPayment = view.findViewById(R.id.btn_pay);
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPayment();
            }
        });

        // handle onclick purchase button
        btnPurchase = view.findViewById(R.id.btn_purchase);
        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickPurchase();
            }
        });

        // handle onclick exchange button
        btnExchange = view.findViewById(R.id.btn_exchange);
        btnExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickExchange();
            }
        });

        // handle onclick location button
        btnLocation = view.findViewById(R.id.btn_location);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickLocation();
            }
        });

        // handle onclick help button
        btnHelp = view.findViewById(R.id.btn_help);
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickHelp();
            }
        });

        return view;
    }

    private void onClickHelp() {
        Toast.makeText(context, R.string.txt_help, Toast.LENGTH_SHORT).show();

    }

    private void onClickLocation() {
        Toast.makeText(context, R.string.txt_location, Toast.LENGTH_SHORT).show();

    }

    private void onClickExchange() {
        Toast.makeText(context, R.string.txt_exchange, Toast.LENGTH_SHORT).show();

    }

    private void onClickPurchase() {
        Toast.makeText(context, R.string.txt_purchase, Toast.LENGTH_SHORT).show();
    }

    private void onClickPayment() {
        Toast.makeText(context, R.string.txt_payment, Toast.LENGTH_SHORT).show();

    }
}