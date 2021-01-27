package com.example.orologio;

public class Tempi {
    private int id;
    private String tempo;

    public Tempi(){

    }
    public Tempi(String tempo){
        super();
        this.tempo=tempo;
    }

    public String toString(){
        return "id: "+id+"\n time: "+tempo+"\n";
    }

    public void setId(int id) {
        this.id=id;
    }

    public void setTempo(String tempo) {
        this.tempo=tempo;
    }

}
