package com.example.orologio;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CronometroFragment();

                case 1:
                    return new SvegliaFragment();

                case 2:
                    return new TempiSalvatiFragment();

                case 3:
                    return new FusoOrarioFragment();

                case 4:
                    return new OraFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
