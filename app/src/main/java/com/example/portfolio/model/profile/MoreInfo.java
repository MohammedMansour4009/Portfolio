package com.example.portfolio.model.profile;

public class MoreInfo {
    private String textTitle;
    private String textInfo;

    public String getTextTitle() {
        return textTitle;
    }

    public MoreInfo(String textTitle, String textInfo) {
        this.textTitle = textTitle;
        this.textInfo = textInfo;
    }

    public MoreInfo() {
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }


}
