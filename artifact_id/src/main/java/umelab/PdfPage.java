package umelab;

import java.util.ArrayList;

public class PdfPage extends PdfObject {

    /**
     * PdfPages
     */
    private PdfPages pages = null;

    /**
     * PdfResource
     */
    private PdfResource resource = null;

    /**
     * PdfTextStream
     */
    private PdfTextStream stream = null;

    /**
     * 参照番号
     */
    private int refno;

    /**
     * このオブジェクトの出力データサイズ
     */
    private int objLength;

    /**
     * Constructor
     */
    public PdfPage() {
        super(PdfConstant.PDF_PAGE);
        entry.put(PdfConstant.PDF_PARENT, null);
        entry.put(PdfConstant.PDF_RESOURCE, null);
        entry.put(PdfConstant.PDF_CONTENTS, null);
        entry.put(PdfConstant.PDF_MEDIABOX, null);
        setRefID(ai.getAndIncrement());
        resource = new PdfResource();
    }

    /**
     * 参照番号を設定する
     * @param no    設定する参照番号
     */
    private void setRefID(int no) {
        this.refno = no;
    }

    /**
     * 参照番号を取得する
     * @return  取得する参照番号
     */
    public int getRefID() {
        return refno;
    }

    /**
     * 参照番号ラベルを取得する
     * @return  取得する参照番号ラベル
     */
    public String getRefStr() {
        String refInfo;
        refInfo = String.valueOf(refno) + " 0 R";
        return refInfo;
    }

    public void setTextStream(PdfTextStream stream) {
        this.stream = stream;
    }

    /**
     * Pagesオブジェクトを設定する
     * @param pages 設定するPagesオブジェクト
     */
    public void setPages(PdfPages pages) {
        this.pages = pages;
    }

    public void addFont(PdfFont font) {
        //ResourceのDictionaryにFontが追加される
        // /Fontがなかったら追加
        resource.addFont(font);
    }

    public ArrayList<PdfObject> getChild() {
        ArrayList<PdfObject> pdfList = new ArrayList<>();
        pdfList.add(resource);
        return pdfList;
    }
    
    public PdfResource getResource() {
        return resource;
    }

    /**
     * PdfPageの情報を出力する
     * @return 出力するPdfPage情報
     */
    public byte[] dumpInfo() {
        String value;
        String str = String.valueOf(getRefID()) + " 0 obj " + PdfConstant.PDF_LF;
        str += PdfConstant.PDF_OP_BRACKET + PdfConstant.PDF_LF;
        //loop for dictionary
        for (String key : entry.keySet()) {
            value = entry.get(key);
            if (key.equals(PdfConstant.PDF_PARENT) && value == null) {
                value = pages.getRefStr();
            } else if (key.equals(PdfConstant.PDF_RESOURCE) && value == null) {
                value = resource.getRefStr();
            } else if (key.equals(PdfConstant.PDF_CONTENTS) && value == null) {
                value = stream.getRefStr();
            } else if (key.equals(PdfConstant.PDF_MEDIABOX) && value == null) {
                //temp setup
                value = "[0.0 0.0 612.0 792.0]";
            }
            str += key + " " + value + PdfConstant.PDF_LF;
        }
        str += PdfConstant.PDF_CL_BRACKET + PdfConstant.PDF_LF;
        str += PdfConstant.PDF_END_OBJ + " " + PdfConstant.PDF_LF;

        objLength = str.length();
        return str.getBytes();
    }

    /**
     * PdfPageのバイトサイズを取得する
     * @return 取得するバイトサイズ
     */
    public int getObjSize() {
        return objLength;
    }

}