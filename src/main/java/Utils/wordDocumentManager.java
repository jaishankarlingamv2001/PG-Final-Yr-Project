package Utils;


import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.WebDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class wordDocumentManager {
    public WebDriver driver;
    public screenshotManager screenshotManager;
    public XWPFDocument wordDoc;
    public XWPFParagraph paragraph;
    public XWPFRun run;
    public FileInputStream readTheFile;
    public FileOutputStream getTheFile;
    public String screenshotNameeee;
    String screenshotPath = System.getProperty("user.dir")+"//src//main//resources//screenshots";
    //String screenshotPath = System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots";
   // String screenshotPath = "C:\\Users\\2269512\\IdeaProjects\\Gujay_Swiggy\\src\\main\\resources\\screenshots";




    public wordDocumentManager(WebDriver driver) {
        this.driver = driver;
        screenshotManager = new screenshotManager(this.driver);


    }


    public void wordDocCreation() {
        wordDoc = new XWPFDocument();
        paragraph = wordDoc.createParagraph();
        run = paragraph.createRun();
        try {
            getTheFile = new FileOutputStream(System.getProperty("user.dir")+"//src//main//resources//Word Document//sample.docx");
            //getTheFile = new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Word Document\\sample.docx");
           // getTheFile = new FileOutputStream("C:\\Users\\2269512\\IdeaProjects\\Gujay_Swiggy\\src\\main\\resources\\Word Document\\sample.docx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void copyAndPasteScreenshot() {
        try {
            screenshotNameeee = screenshotManager.screenshot();
            readTheFile = new FileInputStream(screenshotPath + "//" + screenshotNameeee);
            run.addPicture(readTheFile, XWPFDocument.PICTURE_TYPE_PNG, screenshotPath, Units.toEMU(500), Units.toEMU(300));
            readTheFile.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void flushTheWordDocument() {
        try {
            wordDoc.write(getTheFile);
            getTheFile.close();
            wordDoc.close();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}

