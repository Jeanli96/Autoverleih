/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import Data.Data;
import Data.Vertrag;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Jessi
 */
public class PDFCreator {
    
    private Vertrag vertrag;
    private Data data;
    
    public PDFCreator(Vertrag vertrag, Data data)
    {
        this.vertrag = vertrag;
        this.data = data;
    }
    
    public void ausführen() throws IOException
    {
        String name = data.getKunde(vertrag.getKundenID()-1, true).getName();
        String Vorname = data.getKunde(vertrag.getKundenID()-1, true).getVorname();
        String kfz = vertrag.getKennzeichen();
        String zweitfahrer = vertrag.getZweitfahrer();
        float tagessatz = data.getAuto(kfz).getTagessatz();
        Date abholtermin = vertrag.getAbholtermin();
        Date ruecktermin = vertrag.getRueckgabetermin();
        int vertragsnr = vertrag.getVertragsID();
        
        //Anlegen von PDF und Seite
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        
        //Inhalt auf Seite bringen
        PDPageContentStream content = new PDPageContentStream(document, page, true, true);
        
        content.beginText();
        content.moveTextPositionByAmount(25, 750);
        content.setFont(PDType1Font.TIMES_ROMAN, 40);
        content.drawString("Vertrag");
        content.moveTextPositionByAmount(0, -40);
        content.setFont(PDType1Font.TIMES_ROMAN, 12);
        content.drawString("hier kommt der Text");
        content.endText();
     
      System.out.println("Content added");
      
       content.close();
       
      //PDF speichern
      document.save(new File("C:/Users/Jessi/Desktop/Vertrag_"+vertragsnr+".pdf"));

      
      document.close();
    }
}
