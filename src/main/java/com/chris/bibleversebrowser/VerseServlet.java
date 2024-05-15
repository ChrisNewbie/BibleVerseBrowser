package com.chris.bibleversebrowser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/verses")
public class VerseServlet extends HttpServlet {
    private Osis osis;

    @Override
    public void init() throws ServletException {
        try {
            // Wczytaj plik OSIS podczas inicjalizacji serwletu
            JAXBContext context = JAXBContext.newInstance(Osis.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            osis = (Osis) unmarshaller.unmarshal(new File(getServletContext().getRealPath("/WEB-INF/bible.xml")));
        } catch (JAXBException e) {
            throw new ServletException("Failed to load Bible XML file", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("book");
        String chapterNumber = request.getParameter("chapter");

        List<Verse> verses = getVerses(bookName, chapterNumber);
        request.setAttribute("verses", verses);
        request.getRequestDispatcher("/verses.jsp").forward(request, response);
    }

    private List<Verse> getVerses(String bookName, String chapterNumber) {
        for (Book book : osis.getOsisText().getBooks()) {
            if (book.getOsisID().equalsIgnoreCase(bookName)) {
                for (Chapter chapter : book.getChapters()) {
                    if (chapter.getOsisID().equalsIgnoreCase(chapterNumber)) {
                        return chapter.getVerses();
                    }
                }
            }
        }
        return null;
    }
}
