package com.example.portfolio.model.experience;

public class InfoExperience {
    private int id ;
    private String imageExperience;
    private String iconExperience;
    private String nameExperience;
    private String nameCompany;
    private String companyLocation;
    private String madeExperience;


    public InfoExperience() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InfoExperience(int id, String imageExperience, String iconExperience, String nameExperience, String nameCompany, String companyLocation, String madeExperience) {
        this.id = id;
        this.imageExperience = imageExperience;
        this.iconExperience = iconExperience;
        this.nameExperience = nameExperience;
        this.nameCompany = nameCompany;
        this.companyLocation = companyLocation;
        this.madeExperience = madeExperience;
    }

    public String getImageExperience() {
        return imageExperience;
    }

    public void setImageExperience(String imageExperience) {
        this.imageExperience = imageExperience;
    }

    public String getIconExperience() {
        return iconExperience;
    }

    public void setIconExperience(String iconExperience) {
        this.iconExperience = iconExperience;
    }

    public String getNameExperience() {
        return nameExperience;
    }

    public void setNameExperience(String nameExperience) {
        this.nameExperience = nameExperience;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getMadeExperience() {
        return madeExperience;
    }

    public void setMadeExperience(String madeExperience) {
        this.madeExperience = madeExperience;
    }
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

}
