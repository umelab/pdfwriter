package umelab;

import java.util.HashMap;
import java.util.concurrent.atomic.*;

public class PdfFont extends PdfObject {

    public static final int TIMES_ROMAN = 0;
    public static final int HELVETICA   = 1;
    public static final int COURIER     = 2;
    public static final int GOTHIC      = -1;
    public static final int MINTYO      = -2;

    public static final int TYPE0       = 0;
    public static final int TYPE1       = 1;
    public static final int TYPE2       = 2;
    public static final int TYPE3       = 3;

    private Font font = new Font();
    private PdfDescendantFont descendantFont = null;

    private static AtomicInteger atomicNo = new AtomicInteger(1);

   /**
     * 参照番号
     */
    private int refno1 = 0;

    /**
     * このオブジェクトの出力データサイズ
     */
    private int objLength;

    public PdfFont(){
        this(0);
    }
    
    public PdfFont(int name) {
        this(name, false, false);
    }

    public PdfFont(int fontID, boolean isBold, boolean isItalic) {
        super(PdfConstant.PDF_FONT);
        switch (fontID) {
            case TIMES_ROMAN:
                font.setFontName(PdfConstant.FONT_TIMES_ROMAN);
                font.setType(TYPE1);
                break;
            case HELVETICA:
                font.setFontName(PdfConstant.FONT_HELVETICA);
                font.setType(TYPE1);
                break;
            case COURIER:
                font.setFontName(PdfConstant.FONT_COURIER);
                font.setType(TYPE1);
                break;
            case GOTHIC:
                font.setFontName(PdfConstant.FONT_GOTHIC);
                font.setType(TYPE0);
                break;
            case MINTYO:
                font.setFontName(PdfConstant.FONT_MINTYO);
                font.setType(TYPE0);
                break;
        }
        font.setBold(isBold);
        font.setItalic(isItalic);

        entry.put(PdfConstant.PDF_BASEFONT, font.getBaseFont());
        entry.put(PdfConstant.PDF_SUBTYPE, font.getFontType());
        //Only TYPE0 Font creates FontDescriptor and DescendantFonts obj
        if (fontID < TYPE0) {
            descendantFont = new PdfDescendantFont(font.getBaseFont());
            //need Array obj for DescendantFonts
            entry.put(PdfConstant.PDF_DESCENDANTFONT, PdfConstant.PDF_OP_RECT_BRACKET + descendantFont.getRefStr() + PdfConstant.PDF_CL_RECT_BRACKET);
            entry.put(PdfConstant.PDF_ENCODING, "/90msp-RKSJ-H");
        }
        //ID for font obj
        setRefID(atomicNo.getAndIncrement());
    }

    /**
     * 参照番号を設定する
     * @param no    設定する参照番号
     */
    private void setRefID(int no) {
        this.refno1 = no;
    }

    /**
     * 参照番号を取得する
     * @return  取得する参照番号
     */
    public int getRefID() {
        return refno1;
    }

    /**
     * get refid label
     * @return  specified refid label
     */
    public String getRefStr() {
        String refInfo;
        refInfo = String.valueOf(refno1) + " 0 R";
        return refInfo;
    }

    public String getIndirectFont() {
        return "/F" + String.valueOf(getRefID());
    }

    public byte[] dumpInfo() {
        String fontInfo = "";
        String value;
        fontInfo += "/F" + String.valueOf(getRefID()) + PdfConstant.PDF_LF;
        fontInfo += PdfConstant.PDF_OP_BRACKET + PdfConstant.PDF_LF;
        for (String key : entry.keySet()) {
            value = entry.get(key);
            fontInfo += key + " " + value + PdfConstant.PDF_LF;
        }
        fontInfo += PdfConstant.PDF_CL_BRACKET + PdfConstant.PDF_LF;

        objLength = fontInfo.length();
        return fontInfo.getBytes();
    }

    /**
     * This method is for an unit-test
     * @return
     */
    protected HashMap<String, String> getEntry() {
        return entry;
    }
    
    public int getObjSize() {
        return objLength;
    }
}
