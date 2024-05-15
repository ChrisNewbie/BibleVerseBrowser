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

import jakarta.xml.bind.annotation.XmlValue;
// Importuje XmlValue z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do mapowania pola klasy na wartość tekstową elementu XML.

@XmlAccessorType(XmlAccessType.FIELD)
// Adnotacja określająca, że JAXB ma uzyskiwać dostęp do pól tej klasy bezpośrednio (nie przez metody get/set).
// Wskazuje, że wszystkie pola klasy będą mapowane na elementy XML.

public class Verse {
// Deklaracja publicznej klasy o nazwie Verse. Klasa ta reprezentuje element XML <verse>.

    @XmlAttribute(name = "osisID")
    // Adnotacja mapująca pole osisID na atrybut XML o nazwie "osisID".
    // To oznacza, że wartość pola osisID będzie zapisana jako atrybut <verse osisID="..."> w XML.
    private String osisID;
    // Deklaracja prywatnego pola osisID typu String. To pole będzie przechowywać identyfikator wersetu.

    @XmlValue
    // Adnotacja mapująca pole text na wartość tekstową elementu XML.
    // To oznacza, że wartość pola text będzie zawartością tekstową elementu <verse>.
    private String text;
    // Deklaracja prywatnego pola text typu String.
    // To pole będzie przechowywać tekst wersetu.

    // Getters and setters
    // Komentarz informujący, że poniżej znajdują się metody get i set dla pól osisID i text.

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

    public String getText() {
        return text;
    }
    // Publiczna metoda getter dla pola text.
    // Zwraca wartość pola text.

    public void setText(String text) {
        this.text = text;
    }
    // Publiczna metoda setter dla pola text.
    // Ustawia wartość pola text na wartość przekazaną jako argument.
}
