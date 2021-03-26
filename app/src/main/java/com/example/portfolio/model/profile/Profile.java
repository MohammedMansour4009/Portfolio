package com.example.portfolio.model.profile;

import java.util.List;

public class Profile {
    private String textWelcome;

    public Profile() {
    }

    private String image;
    private String textName;
    private String textWork;
    private List<MoreInfo> moreInfoList;

    public Profile(String textWelcome, String image, String textName, String textWork, List<MoreInfo> moreInfoList) {
        this.textWelcome = textWelcome;
        this.image = image;
        this.textName = textName;
        this.textWork = textWork;
        this.moreInfoList = moreInfoList;
    }

    public String getTextWelcome() {
        return textWelcome;
    }

    public void setTextWelcome(String textWelcome) {
        this.textWelcome = textWelcome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextWork() {
        return textWork;
    }

    public void setTextWork(String textWork) {
        this.textWork = textWork;
    }

    public List<MoreInfo> getMoreInfoList() {
        return moreInfoList;
    }

    public void setMoreInfoList(List<MoreInfo> moreInfoList) {
        this.moreInfoList = moreInfoList;
    }
}
