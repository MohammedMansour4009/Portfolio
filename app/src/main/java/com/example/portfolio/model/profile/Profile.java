package com.example.portfolio.model.profile;

import java.util.List;

public class Profile {
    private String textWelcome;

   private String image;
    private String icHand;

    private String textName;
    private String textWork;
    private List<MoreInfo> moreInfoList;


    private String email;
    private List<Media> mediaList;



    public Profile() {
    }

    public Profile(String textWelcome, String image, String icHand, String textName, String textWork, List<MoreInfo> moreInfoList, String email, List<Media> mediaList) {
        this.textWelcome = textWelcome;
        this.image = image;
        this.icHand = icHand;
        this.textName = textName;
        this.textWork = textWork;
        this.moreInfoList = moreInfoList;
        this.email = email;
        this.mediaList = mediaList;
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

    public String getIcHand() {
        return icHand;
    }

    public void setIcHand(String icHand) {
        this.icHand = icHand;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }
}
