package com.example.portfolio.model.portfolio;

import java.util.List;

public class Portfolio {
  List<InfoApp> infoAppList;

    public Portfolio() {
    }

    public Portfolio(List<InfoApp> infoAppList) {
        this.infoAppList = infoAppList;
    }

    public List<InfoApp> getInfoAppList() {
        return infoAppList;
    }

    public void setInfoAppList(List<InfoApp> infoAppList) {
        this.infoAppList = infoAppList;
    }
}
