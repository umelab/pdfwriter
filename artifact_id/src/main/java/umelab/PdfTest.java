package umelab;

import umelab.util.StringUtil;

/**
 * Hello world!
 *
 */
public class PdfTest
{
    public static void main( String[] args )
    throws Exception {
       String filepath = "c:\\resource\\test.pdf";
        PdfDocument doc = new PdfDocument();
        PdfPage page1 = new PdfPage();
//        PdfPage page2 = new PdfPage();
 
        doc.addPage(page1);
//        doc.addPage(page2);             //ArrayList size -> 2

        //PdfFont font1 = new PdfFont(PdfFont.HELVETICA, false, false);
        PdfFont font2 = new PdfFont(PdfFont.GOTHIC, false, false);
        PdfFont font1 = new PdfFont(PdfFont.MINTYO, false, false);
//        PdfFont font2 = new PdfFont(PdfFont.COURIER, false, false);

        page1.addFont(font1);
        page1.addFont(font2);
//        page2.addFont(font2);
        
        PdfTextStream p1_stream = new PdfTextStream(doc, page1);
        p1_stream.beginText();
        p1_stream.setFont(font1, 46);
        p1_stream.setTextPosition(100, 750);
        String testStr = "あいうえお";
        String convStr = "";
        convStr = StringUtil.convSJISStr(testStr);
        
        p1_stream.setTextJ(convStr);
        p1_stream.setFont(font2, 46);
        p1_stream.setTextPosition(0, -50);
        p1_stream.setTextJ(convStr);
//        stream.setTextPosition(1, -20);
//        stream.setText("Another test in here.");
       p1_stream.endText();
/*
       PdfTextStream p2_stream = new PdfTextStream(doc, page2);
       p2_stream.beginText();
       p2_stream.setFont(font1, 46);
       p2_stream.setTextPosition(100, 200);
       p2_stream.setText("Hello World");
       p2_stream.endText();
*/
       doc.save(filepath);
    }
}
