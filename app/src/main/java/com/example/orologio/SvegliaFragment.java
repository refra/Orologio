package com.example.orologio;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SvegliaFragment extends Fragment {

    EditText editText;
    EditText editText2;
    Button button;

    public SvegliaFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void createAlarm(String messaggio, int ora, int minuti) {
        Intent sveglia = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, messaggio)
                .putExtra(AlarmClock.EXTRA_HOUR, ora)
                .putExtra(AlarmClock.EXTRA_MINUTES, minuti);
        startActivity(sveglia);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_sveglia, container, false);

        editText = (EditText) rootView.findViewById(R.id.editText);
        editText2 = (EditText) rootView.findViewById(R.id.editText2);

        button = (Button) rootView.findViewById(R.id.buttonOk);

        //azzero i campi
        editText.setText("");
        editText2.setText("");

        button.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                createAlarm ("Sveglia", Integer.parseInt (editText.getText().toString()), Integer.parseInt(editText2.getText().toString()));
                editText.setText("");
                editText2.setText("");
            }
        });
        return rootView;

    }
}