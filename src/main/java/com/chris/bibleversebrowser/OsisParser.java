package com.chris.bibleversebrowser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class OsisParser {
    public static Osis parseOsisFile(String filePath) {
        try {
            // Utworzenie kontekstu JAXB dla klasy Osis
            JAXBContext context = JAXBContext.newInstance(Osis.class);

            // Utworzenie unmarshaller do parsowania XML
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Parsowanie pliku XML do obiektu Osis
            return (Osis) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Osis osis = parseOsisFile("path/to/your/bible.xml");
        if (osis != null) {
            // Przykładowe użycie
            for (Book book : osis.getOsisText().getBooks()) {
                System.out.println("Book: " + book.getOsisID());
                for (Chapter chapter : book.getChapters()) {
                    System.out.println(" Chapter " + chapter.getOsisID());
                    for (Verse verse : chapter.getVerses()) {
                        System.out.println("  Verse " + verse.getOsisID() + ": " + verse.getText());
                    }
                }
            }
        }
    }
}
