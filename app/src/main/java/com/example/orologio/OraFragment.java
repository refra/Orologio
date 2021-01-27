package com.example.orologio;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;


public class OraFragment extends Fragment {
    static boolean fuso_selected=false;
    static String fuso_orario;
    public OraFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static void set_fuso(boolean fuso_sel, String fuso){
        fuso_selected=fuso_sel;
        fuso_orario=fuso;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_ora, container, false);
        TextClock tc= rootView.findViewById(R.id.textClock2);
        TextView textView=rootView.findViewById(R.id.textFuso);
        int orientation = getResources().getConfiguration().orientation;
        if ((orientation == Configuration.ORIENTATION_LANDSCAPE)&& (fuso_selected)) {
            tc.setTimeZone(fuso_orario);
            tc.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
        }
        return rootView;
    }
}