package com.example.orologio;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextClock;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.TimeZone;


public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private FragmentStateAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentAdapter fa=new FragmentAdapter(getSupportFragmentManager());
        TabLayout tab= findViewById(R.id.slider);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(fa);
        tab.setupWithViewPager(viewPager);


    }

    //metodi per gestire il db, c'è un piccolo errore da sistemare
    /*public void leggiDB(){
        MySQLiteHelper db= new MySQLiteHelper(this);
        List<Tempi> list= db.getAllTempi();
        final ListView listView= (ListView)findViewById(R.id.list_view);
        final ArrayAdapter<Tempi> adapter= new ArrayAdapter<Tempi>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    public void aggiungiTempo(String tempo){
        MySQLiteHelper db= new MySQLiteHelper(this);
        db.addTempo(tempo);
    }*/


    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }


}



