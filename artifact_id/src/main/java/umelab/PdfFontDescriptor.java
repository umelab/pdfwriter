package umelab;

public class PdfFontDescriptor extends PdfObject {

    private int refno;
    private int objLength;

    public PdfFontDescriptor(String fontname) {
        super(PdfConstant.PDF_FONTDESCRIPTOR);
        setRefID(ai.getAndIncrement());
        entry.put(PdfConstant.PDF_FONTNAME, fontname);
        entry.put("/Flags", "4");
        //As Type1Font is defined FontBBox, ItalicAngle, Ascent, Descent, CapHeight and StemV
        //AcrobatReader ignore these values and output normally.
        entry.put("/FontBBox", "[-437 -340 1147 1317]");
        entry.put("/ItalicAngle", "0");
        entry.put("/Ascent", "1317");
        entry.put("/Descent", "-349");
        entry.put("/CapHeight", "742");
        entry.put("/StemV", "80");

        PdfDocument.add(this);
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
