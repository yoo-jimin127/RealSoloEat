package com.example.realsoloeat;

import com.google.android.gms.maps.model.LatLng;

public class Restrant {
    private  String name;
    private  String loaction;
    private LatLng latLng;
    private int evnet;


    public Restrant(String name, String loaction, LatLng latLng, int evnet) {

        this.evnet = evnet;
        this.name = name;
        this.loaction = loaction;
        this.latLng = latLng;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getLoaction() {
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public int getEvnet() {
        return evnet;
    }

    public void setEvnet(int evnet) {
        this.evnet = evnet;
    }


}