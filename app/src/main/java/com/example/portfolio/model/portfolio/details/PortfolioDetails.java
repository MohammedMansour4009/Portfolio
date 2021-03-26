package com.example.portfolio.model.portfolio.details;

import java.util.List;

public class PortfolioDetails {
    private String image;
    private String icon;
    private String name;
    private String title;
    private String time;
    private String uriGithub;
    private String uriGooglePlay;
    private List<Skills> skillsList;
    private List<ImageApp> imageAppList;
    private String description;
    private String moreDescription;

    public PortfolioDetails() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUriGithub() {
        return uriGithub;
    }

    public void setUriGithub(String uriGithub) {
        this.uriGithub = uriGithub;
    }

    public String getUriGooglePlay() {
        return uriGooglePlay;
    }

    public void setUriGooglePlay(String uriGooglePlay) {
        this.uriGooglePlay = uriGooglePlay;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public List<ImageApp> getImageAppList() {
        return imageAppList;
    }

    public void setImageAppList(List<ImageApp> imageAppList) {
        this.imageAppList = imageAppList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoreDescription() {
        return moreDescription;
    }

    public void setMoreDescription(String moreDescription) {
        this.moreDescription = moreDescription;
    }

    public PortfolioDetails(String image, String icon, String name, String title, String time, String uriGithub, String uriGooglePlay, List<Skills> skillsList, List<ImageApp> imageAppList, String description, String moreDescription) {
        this.image = image;
        this.icon = icon;
        this.name = name;
        this.title = title;
        this.time = time;
        this.uriGithub = uriGithub;
        this.uriGooglePlay = uriGooglePlay;
        this.skillsList = skillsList;
        this.imageAppList = imageAppList;
        this.description = description;
        this.moreDescription = moreDescription;
    }
}
