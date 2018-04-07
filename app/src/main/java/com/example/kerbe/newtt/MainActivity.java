package com.example.kerbe.newtt;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView ac_Text;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_acc:
                    ac_Text.setText(R.string.title_acc);
                    Intent i1 = new Intent(MainActivity.this, AccActivity.class);
                    startActivity(i1);
                    return true;
                case R.id.item_quiz:
                    ac_Text.setText(R.string.title_exam);
                    return true;
                case R.id.item_chat:
                    ac_Text.setText(R.string.title_chat);
                    return true;
                case R.id.item_task:
                    ac_Text.setText(R.string.title_task);
                    Intent i2 = new Intent(MainActivity.this, TaskActivity.class);
                    startActivity(i2);
                    overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
                    return true;
                case R.id.item_schedule:
                    ac_Text.setText(R.string.title_time);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FloatingActionButton fab  = findViewById(R.id.fab);
        //fab.setBackgroundTintList(ColorStateList.valueOf("#00CB64"));

        MainActivity mA = (MainActivity.this);
        mA.setActionBarColor(Color.parseColor("#132635"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        ac_Text = (TextView) findViewById(R.id.ac_text);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setActionBarColor(int actionBarColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }
}
