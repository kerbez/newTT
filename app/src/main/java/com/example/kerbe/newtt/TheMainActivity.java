package com.example.kerbe.newtt;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TheMainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private TextView mTextMessage;
    private TextView ac_Text;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.item_acc:
                    //ac_Text.setText(R.string.title_acc);
                    AccFragment af = new AccFragment();
                    af.setAccId(item.getItemId());
                    ft.replace(R.id.frame_container, af);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    return true;
                case R.id.item_quiz:
                    //ac_Text.setText(R.string.title_exam);
                    QuizFragment qf = new QuizFragment();
                    //qf.setAccId(item.getItemId());
                    ft.replace(R.id.frame_container, qf);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    return true;
                case R.id.item_chat:
                    //ac_Text.setText(R.string.title_chat);
                    ChatFragment cf = new ChatFragment();
                    //af.setAccId(item.getItemId());
                    ft.replace(R.id.frame_container, cf);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    return true;
                case R.id.item_task:
                    //ac_Text.setText(R.string.title_task);
                    TaskFragment ttf = new TaskFragment();
                   // af.setAccId(item.getItemId());
                    ft.replace(R.id.frame_container, ttf);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    return true;
                case R.id.item_schedule:
                    //ac_Text.setText(R.string.title_time);
                    ScheduleFragment sf = new ScheduleFragment();
                    //af.setAccId(item.getItemId());
                    ft.replace(R.id.frame_container, sf);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                    return true;
            }
            return false;
        }
    };
   /* private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_main);

        toolbar = getSupportActionBar();

        AccFragment af = new AccFragment();
        //af.setAccId(item.getItemId());
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, af);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        /*TheMainActivity mA = (TheMainActivity.this);
        mA.setActionBarColor(Color.parseColor("#132635"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        ac_Text = (TextView) findViewById(R.id.ac_text);*/

    }

    public void setActionBarColor(int actionBarColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }
}
