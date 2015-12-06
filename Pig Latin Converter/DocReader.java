import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class DocReader {
    //     public static void readDocFile(String fileName) {
    //         try {
    //             File file = new File(fileName);
    //             FileInputStream fis = new FileInputStream(file.getAbsolutePath());
    // 
    //             HWPFDocument doc = new HWPFDocument(fis);
    // 
    //             WordExtractor we = new WordExtractor(doc);
    // 
    //             String[] paragraphs = we.getParagraphText();
    //             
    //             System.out.println("Total number of paragraph "+paragraphs.length);
    //             for (String para : paragraphs) {
    //                 System.out.println(para.toString());
    //             }
    //             fis.close();
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }   
    //     }

    public List<XWPFParagraph> readDocxFile(String fileName) {
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = Arrays.asList(document.getParagraphs());

            System.out.println("Total number of paragraph "+paragraphs.size());
            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
            }
            return paragraphs;
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeDocxFile(String filename, List<XWPFParagraph> paragraphs) {
        try {

            //             XWPFDocument document = new XWPFDocument(fis);
            // 
            //             List<XWPFParagraph> paragraphs = document.getParagraphs();
            // 
            //             File file = new File(fileName);
            //             FileInputStream fis = new FileInputStream(file.getAbsolutePath());

            System.out.println("Total number of paragraph "+paragraphs.size());
            for (XWPFParagraph para : paragraphs) {
                System.out.println(para.getText());
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readDocxFile("C:\\Test.docx");
        readDocFile("C:\\Test.doc");
    }
}