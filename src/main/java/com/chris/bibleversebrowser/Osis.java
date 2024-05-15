package com.chris.bibleversebrowser;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "osis")
@XmlAccessorType(XmlAccessType.FIELD)
public class Osis {
    @XmlElement(name = "osisText")
    private OsisText osisText;

    // Getters and setters
    public OsisText getOsisText() {
        return osisText;
    }

    public void setOsisText(OsisText osisText) {
        this.osisText = osisText;
    }
}
