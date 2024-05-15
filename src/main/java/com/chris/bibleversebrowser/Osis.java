package com.chris.bibleversebrowser;
// Deklaracja pakietu, w którym znajduje się ta klasa.
// Pakiety pomagają w organizacji kodu.

import jakarta.xml.bind.annotation.XmlAccessType;
// Importuje XmlAccessType z pakietu jakarta.xml.bind.annotation.
// Jest to część JAXB używana do określania, jak pola klasy są mapowane na elementy XML.

import jakarta.xml.bind.annotation.XmlAccessorType;
// Importuje XmlAccessorType z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do definiowania strategii dostępu do pól klasy.

import jakarta.xml.bind.annotation.XmlElement;
// Importuje XmlElement z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do mapowania pól klasy na elementy XML.

import jakarta.xml.bind.annotation.XmlRootElement;
// Importuje XmlRootElement z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do wskazania, że klasa jest korzeniem dokumentu XML.

@XmlRootElement(name = "osis")
// Adnotacja wskazująca, że ta klasa jest korzeniem dokumentu XML.
// Element korzenia XML będzie miał nazwę "osis".

@XmlAccessorType(XmlAccessType.FIELD)
// Adnotacja określająca, że JAXB ma uzyskiwać dostęp do pól tej klasy bezpośrednio (nie przez metody get/set).

public class Osis {
// Deklaracja publicznej klasy o nazwie Osis.
// Jest to główna klasa reprezentująca korzeń dokumentu XML.

    @XmlElement(name = "osisText")
    // Adnotacja mapująca pole osisText na element XML o nazwie "osisText".

    private OsisText osisText;
    // Deklaracja prywatnego pola osisText typu OsisText. To pole będzie mapowane na element XML.

    // Getters and setters
    // Komentarz informujący, że poniżej znajdują się metody get i set dla pola osisText.

    public OsisText getOsisText() {
        return osisText;
    }
    // Publiczna metoda getter dla pola osisText. Zwraca wartość pola osisText.

    public void setOsisText(OsisText osisText) {
        this.osisText = osisText;
    }
    // Publiczna metoda setter dla pola osisText. Ustawia wartość pola osisText na wartość przekazaną jako argument.
}
