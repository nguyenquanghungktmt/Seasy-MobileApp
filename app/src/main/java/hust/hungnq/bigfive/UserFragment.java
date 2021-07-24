package hust.hungnq.bigfive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class UserFragment extends Fragment {
    View view;

    Context context;

    AppCompatButton btnSellerRegister;

    CardView viewCoin, viewFeedback, viewMobileMoney, viewMyQR, viewSetting, viewAboutUs, viewLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user, container, false);
        context = view.getContext();

        btnSellerRegister = view.findViewById(R.id.btn_seller_register);
        btnSellerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnSellerRegister();
            }
        });

        viewCoin = view.findViewById(R.id.view_coin);
        viewCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewCoin();
            }
        });

        viewMyQR = view.findViewById(R.id.view_my_qr);
        viewMyQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewMyQR();
            }
        });

        viewFeedback = view.findViewById(R.id.view_feedback);
        viewFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewFeedback();
            }
        });

        viewMobileMoney = view.findViewById(R.id.view_mobile_money);
        viewMobileMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewMobileMoney();
            }
        });

        viewSetting = view.findViewById(R.id.view_setting);
        viewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewSetting();
            }
        });

        viewAboutUs = view.findViewById(R.id.view_about_us);
        viewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewAboutUs();
            }
        });

        viewLogout = view.findViewById(R.id.view_logout);
        viewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickViewLogout();
            }
        });

        return view;
    }

    private void onClickViewCoin() {
        Toast.makeText(context, "Click " + getString(R.string.txt_coin), Toast.LENGTH_SHORT).show();
    }

    private void onClickViewMyQR() {
//        Toast.makeText(context, "Click " + getString(R.string.txt_my_qr), Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, MyQRCode.class));
    }

    private void onClickViewFeedback() {
        Toast.makeText(context, "Click " + getString(R.string.txt_feedback), Toast.LENGTH_SHORT).show();
    }

    private void onClickViewMobileMoney() {
        Toast.makeText(context, "Click " + getString(R.string.txt_mobile_money), Toast.LENGTH_SHORT).show();
    }

    private void onClickViewSetting() {
        Toast.makeText(context, "Click " + getString(R.string.txt_setting), Toast.LENGTH_SHORT).show();
    }

    private void onClickViewAboutUs() {
        context.startActivity(new Intent(context, AboutUsDetail.class));
//        Toast.makeText(context, "Click " + getString(R.string.txt_about_us), Toast.LENGTH_SHORT).show();
    }

    private void onClickViewLogout() {
        Toast.makeText(context, "Click " + getString(R.string.txt_logout), Toast.LENGTH_SHORT).show();
        getActivity().onBackPressed();
    }

    private void onClickBtnSellerRegister() {
        Toast.makeText(context, "Click Seller Register", Toast.LENGTH_SHORT).show();
    }
}