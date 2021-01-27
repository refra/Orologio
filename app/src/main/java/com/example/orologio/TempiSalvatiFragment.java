package com.example.orologio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TempiSalvatiFragment extends Fragment {
    public TempiSalvatiFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_tempi_salvati, container, false);
        /*MainActivity ma = (MainActivity)getActivity();
        ma.leggiDB();*/
        return rootView;
    }
}