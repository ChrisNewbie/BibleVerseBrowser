package com.chris.bibleversebrowser;
// Deklaracja pakietu, w którym znajduje się ta klasa.
// Pakiety pomagają w organizacji kodu i zapobiegają konfliktom nazw.

import jakarta.servlet.ServletException;
// Importuje ServletException z pakietu jakarta.servlet.
// ServletException jest wyjątkiem rzucanym przez metody serwletów.

import jakarta.servlet.annotation.WebServlet;
// Importuje WebServlet z pakietu jakarta.servlet.annotation.
// WebServlet jest używany do adnotacji klasy serwletu, co pozwala na jego automatyczną rejestrację.

import jakarta.servlet.http.HttpServlet;
// Importuje HttpServlet z pakietu jakarta.servlet.http.
// HttpServlet jest podstawową klasą do tworzenia serwletów obsługujących protokół HTTP.

import jakarta.servlet.http.HttpServletRequest;
// Importuje HttpServletRequest z pakietu jakarta.servlet.http.
// HttpServletRequest jest interfejsem, który zapewnia informacje o żądaniu HTTP.

import jakarta.servlet.http.HttpServletResponse;
// Importuje HttpServletResponse z pakietu jakarta.servlet.http.
// HttpServletResponse jest interfejsem, który zapewnia funkcjonalność odpowiedzi HTTP.

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

import java.io.IOException;
// Importuje IOException z pakietu java.io.
// IOException jest wyjątkiem rzucanym podczas operacji wejścia/wyjścia.

import java.util.List;
// Importuje klasę List z pakietu java.util.
// List to interfejs kolekcji w Javie, który reprezentuje listę elementów.

@WebServlet("/verses")
// Adnotacja @WebServlet oznacza, że ta klasa jest serwletem, a ścieżka URL do tego serwletu to "/verses".

public class VerseServlet extends HttpServlet {
// Deklaracja publicznej klasy VerseServlet, która rozszerza HttpServlet.
// Klasa ta będzie obsługiwać żądania HTTP do ścieżki "/verses".

    private Osis osis;
    // Deklaracja prywatnego pola osis typu Osis.
    // To pole będzie przechowywać obiekt Osis reprezentujący strukturę danych z pliku XML.

    @Override
    public void init() throws ServletException {
        // Nadpisanie metody init, która jest wywoływana podczas inicjalizacji serwletu.
        // Może rzucać wyjątek ServletException.

        try {
            // Blok try-catch do obsługi wyjątków.
            // Wszystkie operacje, które mogą rzucić wyjątek, są umieszczone w bloku try.

            // Wczytaj plik OSIS podczas inicjalizacji serwletu
            // JAXBContext jest fabryką, która zarządza konfiguracją JAXB.
            // Jest używana do tworzenia Unmarshaller.
            JAXBContext context = JAXBContext.newInstance(Osis.class);

            // Utworzenie unmarshaller do parsowania XML
            // Unmarshaller jest używany do konwersji dokumentu XML na obiekt Java.
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Parsowanie pliku XML do obiektu Osis
            // Metoda unmarshal przekształca plik XML na obiekt Osis.
            osis = (Osis) unmarshaller.unmarshal(new File(getServletContext().getRealPath("/WEB-INF/bible.xml")));
        } catch (JAXBException e) {
            // Obsługa wyjątku JAXBException.
            // Jeśli wystąpi błąd podczas parsowania XML, wyjątek jest łapany tutaj.
            throw new ServletException("Failed to load Bible XML file", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nadpisanie metody doGet, która obsługuje żądania GET.
        // Może rzucać wyjątki ServletException i IOException.

        // Pobranie parametrów "book" i "chapter" z żądania HTTP
        String bookName = request.getParameter("book");
        String chapterNumber = request.getParameter("chapter");

        // Pobranie listy wersetów na podstawie nazwy książki i numeru rozdziału
        List<Verse> verses = getVerses(bookName, chapterNumber);

        // Ustawienie atrybutu "verses" w żądaniu HTTP
        request.setAttribute("verses", verses);

        // Przekazanie żądania do widoku JSP "/verses.jsp" w celu wyświetlenia wyników
        request.getRequestDispatcher("/verses.jsp").forward(request, response);
    }

    private List<Verse> getVerses(String bookName, String chapterNumber) {
        // Prywatna metoda getVerses, która przyjmuje nazwę książki i numer rozdziału, i zwraca listę wersetów.

        // Iterowanie przez wszystkie książki w obiekcie Osis
        for (Book book : osis.getOsisText().getBooks()) {

            // Sprawdzenie, czy identyfikator książki odpowiada podanej nazwie książki
            if (book.getOsisID().equalsIgnoreCase(bookName)) {

                // Iterowanie przez wszystkie rozdziały w książce
                for (Chapter chapter : book.getChapters()) {

                    // Sprawdzenie, czy identyfikator rozdziału odpowiada podanemu numerowi rozdziału
                    if (chapter.getOsisID().equalsIgnoreCase(chapterNumber)) {

                        // Zwrócenie listy wersetów dla danego rozdziału
                        return chapter.getVerses();
                    }
                }
            }
        }

        // Zwrócenie null, jeśli książka lub rozdział nie został znaleziony
        return null;
    }
}
