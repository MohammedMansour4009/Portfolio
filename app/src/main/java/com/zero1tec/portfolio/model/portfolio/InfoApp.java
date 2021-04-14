package com.zero1tec.portfolio.model.portfolio;

public class InfoApp {
    private int id ;
    private String imageApp;
    private String iconApp;
    private String nameApp;
    private String descriptionApp;
    private String madeApp;

    public InfoApp() {
    }

    public InfoApp(int id, String imageApp, String iconApp, String nameApp, String descriptionApp, String madeApp) {
        this.id = id;
        this.imageApp = imageApp;
        this.iconApp = iconApp;
        this.nameApp = nameApp;
        this.descriptionApp = descriptionApp;
        this.madeApp = madeApp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageApp() {
        return imageApp;
    }

    public void setImageApp(String imageApp) {
        this.imageApp = imageApp;
    }

    public String getIconApp() {
        return iconApp;
    }

    public void setIconApp(String iconApp) {
        this.iconApp = iconApp;
    }

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    public String getDescriptionApp() {
        return descriptionApp;
    }

    public void setDescriptionApp(String descriptionApp) {
        this.descriptionApp = descriptionApp;
    }

    public String getMadeApp() {
        return madeApp;
    }

    public void setMadeApp(String madeApp) {
        this.madeApp = madeApp;
    }
}
