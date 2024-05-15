package com.chris.bibleversebrowser;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Chapter {
    @XmlAttribute(name = "osisID")
    private String osisID;

    @XmlElement(name = "verse")
    private List<Verse> verses;

    // Getters and setters
    public String getOsisID() {
        return osisID;
    }

    public void setOsisID(String osisID) {
        this.osisID = osisID;
    }

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }
}
