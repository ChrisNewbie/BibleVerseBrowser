package com.chris.bibleversebrowser;
// Deklaracja pakietu, w którym znajduje się ta klasa.
// Pakiety pomagają w organizacji kodu i zapobiegają konfliktom nazw.

import jakarta.xml.bind.annotation.XmlAccessType;
// Importuje XmlAccessType z pakietu jakarta.xml.bind.annotation.
// Jest to część JAXB używana do określania, jak pola klasy są mapowane na elementy XML.

import jakarta.xml.bind.annotation.XmlAccessorType;
// Importuje XmlAccessorType z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do definiowania strategii dostępu do pól klasy.

import jakarta.xml.bind.annotation.XmlElement;
// Importuje XmlElement z pakietu jakarta.xml.bind.annotation.
// Jest to adnotacja używana do mapowania pól klasy na elementy XML.

import java.util.List;
// Importuje klasę List z pakietu java.util.
// List to interfejs kolekcji w Javie, który reprezentuje listę elementów.

@XmlAccessorType(XmlAccessType.FIELD)
// Adnotacja określająca, że JAXB ma uzyskiwać dostęp do pól tej klasy bezpośrednio (nie przez metody get/set).
// Wskazuje, że wszystkie pola klasy będą mapowane na elementy XML.

public class OsisText {
// Deklaracja publicznej klasy o nazwie OsisText.
// Klasa ta reprezentuje element XML <osisText>.

    @XmlElement(name = "div")
    // Adnotacja mapująca pole books na element XML o nazwie "div".
    // To oznacza, że każde wystąpienie listy books będzie reprezentowane jako element <div> w XML.

    private List<Book> books;
    // Deklaracja prywatnego pola books typu List<Book>. To pole będzie mapowane na element <div> w XML.
    // Lista przechowuje obiekty typu Book.

    // Getters and setters
    // Komentarz informujący, że poniżej znajdują się metody get i set dla pola books.

    public List<Book> getBooks() {
        return books;
    }
    // Publiczna metoda getter dla pola books. Zwraca wartość pola books, czyli listę obiektów typu Book.

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    // Publiczna metoda setter dla pola books. Ustawia wartość pola books na wartość przekazaną jako argument.
    // Przyjmuje listę obiektów typu Book.
}
