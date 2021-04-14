package com.example.portfolio.model.experience.details;

public class InfoResponsibilities {
    private String numberResponsibilities;
    private String infoResponsibilities;

    public InfoResponsibilities(String numberResponsibilities, String infoResponsibilities) {
        this.numberResponsibilities = numberResponsibilities;
        this.infoResponsibilities = infoResponsibilities;
    }

    public InfoResponsibilities() {
    }

    public String getNumberResponsibilities() {
        return numberResponsibilities;
    }

    public void setNumberResponsibilities(String numberResponsibilities) {
        this.numberResponsibilities = numberResponsibilities;
    }

    public String getInfoResponsibilities() {
        return infoResponsibilities;
    }

    public void setInfoResponsibilities(String infoResponsibilities) {
        this.infoResponsibilities = infoResponsibilities;
    }
}
