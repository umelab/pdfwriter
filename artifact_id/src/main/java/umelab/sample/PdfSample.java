package umelab.sample;

import umelab.pdf.PdfDocument;
import umelab.pdf.PdfPage;

public class PdfSample {

    public static void main(String args[]) {
        try {
            //create pdf document
            PdfDocument doc = new PdfDocument();
            PdfPage page = new PdfPage(PdfPage.A4_V);
            page.setMargin(30, 30, 40, 40);
            doc.addPage(page);

            PdfFont font = FontFactory.create(PdfFont.KozGoPro, fontSize, isItalic, isBold);
            
            String text1 = "あいうえお";
            String text2 = "かきくけこ";
            PdfText pdfText1 = new PdfText(text1, font);
            PdfText pdfText2 = new PdfText(text2, font);

            doc.open();
            doc.setPdfText(pdfText1);
            doc.setPdfText(PdfText2);
            doc.close();

            PdfWriter writer = new PdfWriter(doc);
            writer.save("c:\\resource\\test.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}