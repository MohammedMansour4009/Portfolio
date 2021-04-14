package com.zero1tec.portfolio.model.portfolio.details;

public class Skills {
    private String icon;
    private String name;

    public Skills(String icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public Skills() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
