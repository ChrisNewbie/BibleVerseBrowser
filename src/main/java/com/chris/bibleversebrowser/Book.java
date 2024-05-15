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

public class Book {
// Deklaracja publicznej klasy o nazwie Book.
// Klasa ta reprezentuje element XML <book>.

    @XmlAttribute(name = "osisID")
    // Adnotacja mapująca pole osisID na atrybut XML o nazwie "osisID".
    // To oznacza, że wartość pola osisID będzie zapisana jako atrybut <book osisID="..."> w XML.
    private String osisID;
    // Deklaracja prywatnego pola osisID typu String.
    // To pole będzie przechowywać identyfikator książki.

    @XmlElement(name = "div")
    // Adnotacja mapująca pole chapters na element XML o nazwie "div".
    // To oznacza, że lista rozdziałów będzie reprezentowana jako element <div> w XML.
    private List<Chapter> chapters;
    // Deklaracja prywatnego pola chapters typu List<Chapter>.
    // To pole będzie przechowywać listę obiektów typu Chapter.

    // Getters and setters
    // Komentarz informujący, że poniżej znajdują się metody get i set dla pól osisID i chapters.

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

    public List<Chapter> getChapters() {
        return chapters;
    }
    // Publiczna metoda getter dla pola chapters.
    // Zwraca wartość pola chapters, czyli listę obiektów typu Chapter.

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
    // Publiczna metoda setter dla pola chapters.
    // Ustawia wartość pola chapters na wartość przekazaną jako argument.
}
