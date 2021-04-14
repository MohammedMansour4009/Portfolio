package com.example.portfolio.model.setting;

import java.util.List;

public class TitleOptions {
    private List<Options> optionsList;
    private String title;


    public TitleOptions() {
    }

    public TitleOptions(List<Options> optionsList, String title) {
        this.optionsList = optionsList;
        this.title = title;
    }

    public List<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List<Options> optionsList) {
        this.optionsList = optionsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
