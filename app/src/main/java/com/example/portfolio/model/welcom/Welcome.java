package com.example.portfolio.model.welcom;

import java.util.List;

public class Welcome {
  private List<InfoWelcome> infoWelcomeList;

    public Welcome(List<InfoWelcome> infoWelcomeList) {
        this.infoWelcomeList = infoWelcomeList;
    }

    public List<InfoWelcome> getInfoWelcomeList() {
        return infoWelcomeList;
    }

    public void setInfoWelcomeList(List<InfoWelcome> infoWelcomeList) {
        this.infoWelcomeList = infoWelcomeList;
    }
}
