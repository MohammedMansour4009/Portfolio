package com.example.portfolio.model.experience.details;

import java.util.List;

public class ExperienceDetails {
    private String background;
    private String icon;
    private String name;
    private String nameCompany;
    private String place;
    private String time;
    private String uriGooglePlay;
    private String uriWepSite;
    private String info;
    private String titleResponsibilities;
    private List<InfoResponsibilities> responsibilitiesList;
    private String titleLinks;
    private List<InfoLink> infoLinkList;
    private LatLngMy latLngMy;

    public ExperienceDetails(String background, String icon, String name,  String nameCompany, String place, String time, String uriGooglePlay, String uriWepSite, String info, String titleResponsibilities, List<InfoResponsibilities> responsibilitiesList, String titleLinks, List<InfoLink> infoLinkList, LatLngMy latLngMy) {
        this.background = background;
        this.icon = icon;
        this.name = name;
        this.nameCompany = nameCompany;
        this.place = place;
        this.time = time;
        this.uriGooglePlay = uriGooglePlay;
        this.uriWepSite = uriWepSite;
        this.info = info;
        this.titleResponsibilities = titleResponsibilities;
        this.responsibilitiesList = responsibilitiesList;
        this.titleLinks = titleLinks;
        this.infoLinkList = infoLinkList;
        this.latLngMy = latLngMy;
    }

    public ExperienceDetails() {
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUriGooglePlay() {
        return uriGooglePlay;
    }

    public void setUriGooglePlay(String uriGooglePlay) {
        this.uriGooglePlay = uriGooglePlay;
    }

    public String getUriWepSite() {
        return uriWepSite;
    }

    public void setUriWepSite(String uriWepSite) {
        this.uriWepSite = uriWepSite;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitleResponsibilities() {
        return titleResponsibilities;
    }

    public void setTitleResponsibilities(String titleResponsibilities) {
        this.titleResponsibilities = titleResponsibilities;
    }

    public List<InfoResponsibilities> getResponsibilitiesList() {
        return responsibilitiesList;
    }

    public void setResponsibilitiesList(List<InfoResponsibilities> responsibilitiesList) {
        this.responsibilitiesList = responsibilitiesList;
    }

    public String getTitleLinks() {
        return titleLinks;
    }

    public void setTitleLinks(String titleLinks) {
        this.titleLinks = titleLinks;
    }

    public List<InfoLink> getInfoLinkList() {
        return infoLinkList;
    }

    public void setInfoLinkList(List<InfoLink> infoLinkList) {
        this.infoLinkList = infoLinkList;
    }

    public LatLngMy getLatLngMy() {
        return latLngMy;
    }

    public void setLatLngMy(LatLngMy latLngMy) {
        this.latLngMy = latLngMy;
    }
}
