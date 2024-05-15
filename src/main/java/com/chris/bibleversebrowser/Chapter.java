package com.chris.bibleversebrowser;
// Deklaracja pakietu, w którym znajduje się ta klasa.
// Pakiety pomagają w organizacji kodu i zapobiegają konfliktom nazw.

import jakarta.xml.bind.annotation.XmlAccessType;
// Importuje XmlAccessType z pakietu jakarta.xml.bind.annotation.
// Jest to część JAXB używana do określania, jak pola klasy są mapowane na elementy XML.

import jakarta.xml.bind.annotation.XmlAccessorType;
// Importuje XmlAccessorType z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do definiowania strategii dostępu do pól klasy.

import jakarta.xml.bind.annotation.XmlAttribute;
// Importuje XmlAttribute z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do mapowania pola klasy na atrybut XML.

import jakarta.xml.bind.annotation.XmlElement;
// Importuje XmlElement z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do mapowania pola klasy na element XML.

import java.util.List;
// Importuje klasę List z pakietu java.util.
// List to interfejs kolekcji w Javie, który reprezentuje listę elementów.

@XmlAccessorType(XmlAccessType.FIELD)
// Adnotacja określająca, że JAXB ma uzyskiwać dostęp do pól tej klasy bezpośrednio (nie przez metody get/set).
// Wskazuje, że wszystkie pola klasy będą mapowane na elementy XML.

public class Chapter {
// Deklaracja publicznej klasy o nazwie Chapter.
// Klasa ta reprezentuje element XML <chapter>.

    @XmlAttribute(name = "osisID")
    // Adnotacja mapująca pole osisID na atrybut XML o nazwie "osisID".
    // To oznacza, że wartość pola osisID będzie zapisana jako atrybut <chapter osisID="..."> w XML.
    private String osisID;
    // Deklaracja prywatnego pola osisID typu String.
    // To pole będzie przechowywać identyfikator rozdziału.

    @XmlElement(name = "verse")
    // Adnotacja mapująca pole verses na element XML o nazwie "verse".
    // To oznacza, że lista wersetów będzie reprezentowana jako element <verse> w XML.
    private List<Verse> verses;
    // Deklaracja prywatnego pola verses typu List<Verse>.
    // To pole będzie przechowywać listę obiektów typu Verse.

    // Getters and setters
    // Komentarz informujący, że poniżej znajdują się metody get i set dla pól osisID i verses.

    public String getOsisID() {
        return osisID;
    }
    // Publiczna metoda getter dla pola osisID.
    // Zwraca wartość pola osisID.

    public void setOsisID(String osisID) {
        this.osisID = osisID;
    }
    // Publiczna metoda setter dla pola osisID.
    // Ustawia wartość pola osisID na wartość przekazaną jako argument.

    public List<Verse> getVerses() {
        return verses;
    }
    // Publiczna metoda getter dla pola verses.
    // Zwraca wartość pola verses, czyli listę obiektów typu Verse.

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }
    // Publiczna metoda setter dla pola verses.
    // Ustawia wartość pola verses na wartość przekazaną jako argument.
}
