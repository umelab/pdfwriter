package umelab;

public class PdfDescendantFont extends PdfObject {

    private static final String CIDSYSTEMINFO   = "<<\n/Registry (Adobe)\n/Ordering (Japan1)\n/Supplement 2\n>>";
    //private static final String WIDTH           = "[ 1 [ 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 ] 231 [ 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 ] 327 [ 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 ] 631 [ 500 ] ]";
    private static final String WIDTH           = "[ 1 [ 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 ] 231 [ 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 ] 327 [ 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 500 ] 631 [ 500 ] ]";
    private int refno;
    private int objLength;
    private PdfFontDescriptor pdfDesc = null;
    
    PdfDescendantFont(String fontname) {
        super(PdfConstant.PDF_FONT);
        setRefID(ai.getAndIncrement());
        PdfDocument.add(this);
        
        entry.put(PdfConstant.PDF_SUBTYPE, PdfConstant.PDF_CIDFONTTYPE0);
        entry.put(PdfConstant.PDF_BASEFONT, fontname);
        entry.put(PdfConstant.PDF_CIDSystemInfo, CIDSYSTEMINFO);
        pdfDesc = new PdfFontDescriptor(fontname);
        entry.put(PdfConstant.PDF_FONTDESCRIPTOR, pdfDesc.getRefStr());
        entry.put(PdfConstant.PDF_WIDTH, WIDTH);
    }

    /**
     * setup refid
     * @param no    specified refid
     */
    private void setRefID(int no) {
        this.refno = no;
    }

    /**
     * get refid
     * @return  specified refid
     */
    public int getRefID() {
        return refno;
    }

    /**
     * get refid label
     * @return  specified refid label
     */
    public String getRefStr() {
        String refInfo;
        refInfo = String.valueOf(refno) + " 0 R";
        return refInfo;
    }

    /**
     * 
     */
    public byte[] dumpInfo() {    
        String info = "";
        info += String.valueOf(getRefID()) + " 0 obj " + PdfConstant.PDF_LF;
        info += PdfConstant.PDF_OP_BRACKET + PdfConstant.PDF_LF;
        for (String key : entry.keySet()) {
            info += key + " " + entry.get(key) + PdfConstant.PDF_LF;
        }
        info += PdfConstant.PDF_CL_BRACKET + PdfConstant.PDF_LF;
        info += "endobj " + PdfConstant.PDF_LF;

        objLength = info.length();

        return info.getBytes();
    }

    public int getObjSize() {
        return objLength;
    }

}
