package hust.hungnq.bigfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        connectView();
        setupViewPager();
        getData();

    }

    private void connectView() {
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.pager);
    }

    private void getData() {
        String userName = getIntent().getStringExtra(LoginActivity.KEY_USER_TO_MAIN);
        String password = getIntent().getStringExtra(LoginActivity.KEY_PASSWORD_TO_MAIN);

        String helloText = context.getResources().getString(R.string.login_success);
        helloText = completeText(helloText, new String[]{userName, password});
    }

    private String completeText(String source, String[] items) {
        for (int i = 0; i < items.length; i++) {
            source = source.replace("{" + i + "}", items[i]);
        }
        return source;
    }

    private void setupViewPager() {
        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
               @Override
               public void onTabSelected(TabLayout.Tab tab) {
                   viewPager.setCurrentItem(tab.getPosition());
                   int tabIconColor = ContextCompat.getColor(context, R.color.tmp_color);
                   tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
               }

               @Override
               public void onTabUnselected(TabLayout.Tab tab) {
                   int tabIconColor = ContextCompat.getColor(context, R.color.default_color);
                   tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
               }

               @Override
               public void onTabReselected(TabLayout.Tab tab) {

               }
           }

        );
    }
}