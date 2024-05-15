package com.chris.bibleversebrowser;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Verse {
    @XmlAttribute(name = "osisID")
    private String osisID;

    @XmlValue
    private String text;

    // Getters and setters
    public String getOsisID() {
        return osisID;
    }

    public void setOsisID(String osisID) {
        this.osisID = osisID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
