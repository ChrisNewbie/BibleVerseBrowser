package com.chris.bibleversebrowser;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlAttribute(name = "osisID")
    private String osisID;

    @XmlElement(name = "div")
    private List<Chapter> chapters;

    // Getters and setters
    public String getOsisID() {
        return osisID;
    }

    public void setOsisID(String osisID) {
        this.osisID = osisID;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
