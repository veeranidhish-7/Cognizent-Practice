package FactoryMethodPatternExample;

public class Main {
    public static void main(String[] args) {

        System.out.println(" Processing of a 'WORD' Document: ");
        DocumentFactory wordFactory = new WordFactory();
        // We use the factory to manage the document without ever typing 'new WordDocument()' here
        wordFactory.manageDocument();

        System.out.println(" Processing 'PDF' Document: ");
        DocumentFactory pdfFactory = new PdfFactory();
        pdfFactory.manageDocument();

        System.out.println(" Processing 'EXCEL' Documen: ");
        DocumentFactory excelFactory = new ExcelFactory();
        excelFactory.manageDocument();
    }
}
