package com.example.orologio;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class CronometroFragment extends Fragment{

    Button start, stop, clear,save;
    boolean isOn=false;
    TextView cronos;
    Thread cronometro;
    int milli=0, sec=0, min=0;
    Handler h=new Handler();

    Chronometer chrono;
    long lastPause;
    boolean ritchig;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_cronometro, container, false);
        start=(Button)rootView.findViewById(R.id.buttonStart);
        stop=(Button)rootView.findViewById(R.id.buttonStop);
        clear=(Button)rootView.findViewById(R.id.buttonClear);
        save=(Button)rootView.findViewById(R.id.buttonSave);
        chrono=(Chronometer)rootView.findViewById(R.id.crono);
        ritchig=true;
        new Chronom().execute();
        return rootView;
    }


    private class Chronom extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... args){
            start.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();
                    System.out.println(SystemClock.elapsedRealtime());
                    ritchig=false;
                }
            });
            stop.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    lastPause = SystemClock.elapsedRealtime();
                    chrono.stop();
                    ritchig = true;
                }
            });
            clear.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    chrono.setBase(SystemClock.elapsedRealtime());
                    System.out.println(chrono.getBase());
                    ritchig = false;
                }
            });
            /*save.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    chrono.stop();
                    String text= (String) chrono.getText();
                    MainActivity ma= (MainActivity)getActivity();
                    ma.aggiungiTempo(text);
                }
            });*/
            return null;
        }

        protected void onProgressUpdate (Void... progress){

        }
        protected void onPostExecute(Void result){

        }
    }

    public CronometroFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
//questa parte commentata funziona come cronometro creato tramite textView e visualizza anche i millisecondi
    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_cronometro, container, false);
        start=(Button)rootView.findViewById(R.id.buttonStart);
        stop=(Button)rootView.findViewById(R.id.buttonStop);
        clear=(Button)rootView.findViewById(R.id.buttonClear);
        save=(Button)rootView.findViewById(R.id.buttonSave);
        cronos=(TextView)rootView.findViewById(R.id.chronometer);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        clear.setOnClickListener(this);
        save.setOnClickListener(this);

        cronometro=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if (isOn){
                        try {
                            Thread.sleep(1);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        milli++;
                        if(milli==999){
                            sec++;
                            milli=0;
                        }
                        if(sec==59){
                            min++;
                            sec=0;
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                String m="",s="",mi="";
                                if (milli<10){
                                    m="00"+milli;
                                }else if(milli<100){
                                    m="0"+milli;
                                }else{
                                    m=""+milli;
                                }
                                if (sec<10){
                                    s="0"+sec;
                                }else{
                                    s=""+sec;
                                }
                                if (min<10){
                                    mi="0"+min;
                                }else{
                                    mi=""+min;
                                }
                                cronos.setText(mi+":"+s+":"+m);
                            }
                        });
                    }
                }
            }
        });
        cronometro.start();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonStart:
                isOn=true;
                break;
            case R.id.buttonStop:
                isOn=false;
                break;
            case R.id.buttonClear:
                isOn=false;
                milli=0;
                sec=0;
                min=0;
                cronos.setText("00:00:000");
                break;
            //case R.id.buttonSave:
              //  isOn=false;
                //break;
        }
    }*/
}