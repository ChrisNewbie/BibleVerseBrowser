package com.chris.bibleversebrowser;
// Deklaracja pakietu, w którym znajduje się ta klasa.
// Pakiety pomagają w organizacji kodu i zapobiegają konfliktom nazw.

import jakarta.xml.bind.JAXBContext;
// Importuje JAXBContext z pakietu jakarta.xml.bind.
// JAXBContext jest używany do zarządzania procesem konwersji między obiektami Java a dokumentami XML.

import jakarta.xml.bind.JAXBException;
// Importuje JAXBException z pakietu jakarta.xml.bind.
// JAXBException jest wyjątkiem, który może być rzucany podczas operacji JAXB.

import jakarta.xml.bind.Unmarshaller;
// Importuje Unmarshaller z pakietu jakarta.xml.bind.
// Unmarshaller jest używany do konwersji dokumentów XML na obiekty Java.

import java.io.File;
// Importuje klasę File z pakietu java.io.
// File jest używany do reprezentowania plików i ścieżek do plików.

public class OsisParser {
// Deklaracja publicznej klasy o nazwie OsisParser.
// Klasa ta zawiera metody do parsowania pliku XML na obiekt Osis.

    public static Osis parseOsisFile(String filePath) {
        // Deklaracja publicznej, statycznej metody parseOsisFile,
        // która przyjmuje ścieżkę do pliku XML jako argument i zwraca obiekt Osis.

        try {
            // Blok try-catch do obsługi wyjątków.
            // Wszystkie operacje, które mogą rzucić wyjątek, są umieszczone w bloku try.

            // Utworzenie kontekstu JAXB dla klasy Osis
            // JAXBContext jest fabryką, która zarządza konfiguracją JAXB.
            // Jest używana do tworzenia Unmarshaller.
            JAXBContext context = JAXBContext.newInstance(Osis.class);

            // Utworzenie unmarshaller do parsowania XML
            // Unmarshaller jest używany do konwersji dokumentu XML na obiekt Java.
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Parsowanie pliku XML do obiektu Osis
            // Metoda unmarshal przekształca plik XML na obiekt Osis.
            return (Osis) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            // Obsługa wyjątku JAXBException.
            // Jeśli wystąpi błąd podczas parsowania XML, wyjątek jest łapany tutaj.
            e.printStackTrace();
            // W przypadku błędu metoda zwraca null.
            return null;
        }
    }

    public static void main(String[] args) {
        // Deklaracja metody main, która jest punktem wejścia programu.
        // Metoda ta jest używana do uruchomienia programu.

        // Wywołanie metody parseOsisFile z określoną ścieżką do pliku XML
        // i przypisanie wyniku (obiekt Osis) do zmiennej osis.
        Osis osis = parseOsisFile("path/to/your/bible.xml");

        if (osis != null) {
            // Sprawdzenie, czy obiekt osis nie jest null, czyli czy parsowanie zakończyło się sukcesem.

            // Przykładowe użycie
            // Pętla iterująca po wszystkich książkach w obiekcie osis.
            for (Book book : osis.getOsisText().getBooks()) {
                // Wypisanie identyfikatora książki.
                System.out.println("Book: " + book.getOsisID());

                // Pętla iterująca po wszystkich rozdziałach w danej książce.
                for (Chapter chapter : book.getChapters()) {
                    // Wypisanie identyfikatora rozdziału.
                    System.out.println(" Chapter " + chapter.getOsisID());

                    // Pętla iterująca po wszystkich wersetach w danym rozdziale.
                    for (Verse verse : chapter.getVerses()) {
                        // Wypisanie identyfikatora wersetu i jego tekstu.
                        System.out.println("  Verse " + verse.getOsisID() + ": " + verse.getText());
                    }
                }
            }
        }
    }
}
