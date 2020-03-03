package com.example.golkhune;

public class Item {
    private int uAvatar;
    private String uName;
    private String uWater ;
    private String uLight ;
    private String uTemperature;
    private String uMessage;

    public Item() {
    }

    public Item(int uAvatar, String uName, String uWater, String uLight, String uTemperature, String uMessage) {
        this.uAvatar = uAvatar;
        this.uName = uName;
        this.uWater = uWater;
        this.uLight = uLight;
        this.uTemperature = uTemperature;
        this.uMessage = uMessage;

    }

    public Item(String uName) {
        this.uName = uName;
    }

    public int getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(int uAvatar) {
        this.uAvatar = uAvatar;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuWater() {
        return uWater;
    }

    public void setuWater(String uWater) {
        this.uWater = uWater;
    }

    public String getuLight() {
        return uLight;
    }

    public void setuLight(String uLight) {
        this.uLight = uLight;
    }

    public String getuTemperature() {
        return uTemperature;
    }

    public void setuTemperature(String uTemperature) {
        this.uTemperature = uTemperature;
    }

    public String getuMessage() {
        return uMessage;
    }

    public void setuMessage(String uMessage) {
        this.uMessage = uMessage;
    }
}
