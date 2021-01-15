package umelab;

public class PdfConstant {
    
    /**
     * 改行
     */
    public static final String PDF_LF               = "\n";

    /**
     * ディクショナリ開始マーク
     */
    public static final String PDF_OP_BRACKET       = "<<";

    /**
     * ディクショナリ終了マーク
     */
    public static final String PDF_CL_BRACKET       = ">>";

    /**
     * 配列開始マーク
     */
    public static final String PDF_OP_RECT_BRACKET  = "[";

    /**
     * 配列終了マーク
     */
    public static final String PDF_CL_RECT_BRACKET  = "]";

    /**
     * テキスト開始マーク
     */
    public static final String PDF_OP_CIR_BRACKET = "(";

    /**
     * テキスト終了マーク
     */
    public static final String PDF_CL_CIR_BRACKET = ")";
    
    /**
     * Indirectオブジェクト開始マーク
     */
    public static final String PDF_START_OBJ        = "obj";

    /**
     * Indirectオブジェクト終了マーク
     */
    public static final String PDF_END_OBJ          = "endobj";

    /**
     * xref開始マーク
     */
    public static final String PDF_XREF             = "xref";

    /**
     * trailer開始マーク
     */
    public static final String PDF_TRAILER          = "trailer";

    /**
     * xref start開始マーク
     */
    public static final String PDF_STARTXREF        = "startxref";

    /**
     * EOF
     */
    public static final String PDF_EOF              = "%%EOF";

    /**
     * Catalog
     */
    public static final String PDF_CATALOG          = "/Catalog";

    /**
     * Version
     */
    public static final String PDF_VERSION          = "/Version";
    /**
     * Pages
     */
    public static final String PDF_PAGES            = "/Pages";

    /**
     * Kids
     */
    public static final String PDF_KIDS             = "/Kids";

    /**
     * Count
     */
    public static final String PDF_COUNT            = "/Count";

    /**
     * Page
     */
    public static final String PDF_PAGE             = "/Page";

    /**
     * Parent
     */
    public static final String PDF_PARENT           = "/Parent";

    /**
     * Contents
     */
    public static final String PDF_CONTENTS         = "/Contents";

    /**
     * MediaBox
     */
    public static final String PDF_MEDIABOX         = "/MediaBox";

    /**
     * Resource
     */
    public static final String PDF_RESOURCE         = "/Resources";
    
    /**
     * Font
     */
    public static final String PDF_FONT             = "/Font";

    /**
     * BaseFont
     */
    public static final String PDF_BASEFONT         = "/BaseFont";

    /**
     * SubType
     */
    public static final String PDF_SUBTYPE          = "/Subtype";

    /**
     * FontDescriptor
     */
    public static final String PDF_FONTDESCRIPTOR   = "/FontDescriptor";

    /**
     * DescendanFont
     */
    public static final String PDF_DESCENDANTFONT   = "/DescendantFonts";

    /**
     * Encode
     */
    public static final String PDF_ENCODING         = "/Encoding";

    /**
     * CIDFontType0
     */
    public static final String PDF_CIDFONTTYPE0     = "/CIDFontType0";

    /**
     * W
     */
    public static final String PDF_WIDTH            = "/W";

    /**
     * Fontname
     */
    public static final String PDF_FONTNAME         = "/FontName";

    /**
     * CIDSystemInfo
     */
    public static final String PDF_CIDSystemInfo        = "/CIDSystemInfo";

    /**
     * ProcSet
     */
    public static final String PDF_PROCSET          = "/ProcSet";

    /**
     * Root
     */
    public static final String PDF_ROOT             = "/Root";

    /**
     * Size
     */
    public static final String PDF_SIZE             = "/Size";

    public static final String PDF_PROCSET_DEFAULT  = "[ /PDF /Text /ImageB /ImageC /ImageI ]";
    public static final String PDF_XREF_HEADER      = "0000000000 65535 f";

    /**
     * Standard 14 fonts
     */
    public static final String FONT_TIMES_ROMAN         = "Times-Roman";

    public static final String FONT_COURIER             = "Courier";

    public static final String FONT_HELVETICA           = "Helvetica";

    public static final String FONT_GOTHIC              = "KozGoPr6N-Regular";

    public static final String FONT_MINTYO              = "KozMinPr6N-Regular";

    
}
