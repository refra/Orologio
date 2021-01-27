package com.example.orologio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

public class FusoOrarioFragment extends Fragment {
    Button but;
    String fuso="";
    Spinner spin;
    public FusoOrarioFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_fuso_orario, container, false);
        but=(Button) rootView.findViewById(R.id.buttonConferma);
        spin=(Spinner) rootView.findViewById(R.id.spinner);
        but.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fuso= spin.getSelectedItem().toString();
                OraFragment.set_fuso(true, fuso);
            }

        });

        return rootView;
    }
}