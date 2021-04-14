package com.example.portfolio.model.setting;

public class Options {
    private String icon ;
    private String name;
    private String description;
    private String uriPath;

    public Options(String icon, String name, String description, String uriPath) {
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.uriPath = uriPath;
    }

    public Options() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }
}
