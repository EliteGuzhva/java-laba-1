package pdfparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.PrintWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfParser {
    public static void main(String args[]) {
        File file = new File("demo.pdf");

        String text = "";

        // Read document
        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
            document.close();

        } catch (IOException e) {
            text = e.getMessage();
        }

        // Print contents or error
        System.out.println(text);

        // Write to another file
        try (PrintWriter out = new PrintWriter("build/output/out.txt"))
        {
            out.println(text);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
