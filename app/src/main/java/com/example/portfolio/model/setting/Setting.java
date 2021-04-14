package com.example.portfolio.model.setting;

import java.util.List;

public class Setting {
    List<TitleOptions> titleOptions;
    public Setting() {
    }

    public Setting(List<TitleOptions> titleOptions) {
        this.titleOptions = titleOptions;
    }

    public List<TitleOptions> getTitleOptions() {
        return titleOptions;
    }

    public void setTitleOptions(List<TitleOptions> titleOptions) {
        this.titleOptions = titleOptions;
    }
}
