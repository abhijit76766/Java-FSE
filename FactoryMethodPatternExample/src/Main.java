public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        wordFactory.openDocument();
        pdfFactory.openDocument();
        excelFactory.openDocument();
    }
}

