package com.example.portfolio.model.experience;

public class InfoExperience {
    private String imageExperience;
    private String iconExperience;
    private String nameExperience;
    private String descriptionExperience;
    private String madeExperience;

    public InfoExperience() {
    }

    public InfoExperience(String imageExperience, String iconExperience, String nameExperience, String descriptionExperience, String madeExperience) {
        this.imageExperience = imageExperience;
        this.iconExperience = iconExperience;
        this.nameExperience = nameExperience;
        this.descriptionExperience = descriptionExperience;
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

    public String getDescriptionExperience() {
        return descriptionExperience;
    }

    public void setDescriptionExperience(String descriptionExperience) {
        this.descriptionExperience = descriptionExperience;
    }

    public String getMadeExperience() {
        return madeExperience;
    }

    public void setMadeExperience(String madeExperience) {
        this.madeExperience = madeExperience;
    }
}
