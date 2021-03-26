package com.example.portfolio.model.experience;

import java.util.List;

public class Experience {
    List<InfoExperience> experienceList;


    public Experience() {
    }

    public Experience(List<InfoExperience> infoAppList) {
        this.experienceList = infoAppList;
    }

    public List<InfoExperience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<InfoExperience> experienceList) {
        this.experienceList = experienceList;
    }
}

