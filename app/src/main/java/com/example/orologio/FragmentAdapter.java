package com.example.orologio;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 5;
    private Fragment cron,sveglia,tempi,fuso,ora;
    public FragmentAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        cron=new CronometroFragment();
        sveglia=new SvegliaFragment();
        tempi= new TempiSalvatiFragment();
        fuso= new FusoOrarioFragment();
        ora= new OraFragment();
    }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return cron;

                case 1:
                    return sveglia;

                case 2:
                    return tempi;

                case 3:
                    return fuso;

                case 4:
                    return ora;

                default:
                    return null;
            }
        }


        @Override
        public int getCount() {

        return NUM_PAGES;

        }
}
