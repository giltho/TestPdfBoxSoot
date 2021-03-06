package com.example;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String filename = "sample.pdf";
        String message = "Hello World!";

        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDFont font = PDType1Font.HELVETICA;

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setFont(font, 30);
            contents.newLineAtOffset(50, 700);
            contents.showText(message);
            contents.endText();
            contents.close();
            doc.save(filename);
        } finally {
            doc.close();
        }
    }
}
