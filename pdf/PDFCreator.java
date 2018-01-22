/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf;

import Data.Auto;
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
    
    public void ausfuehren() 
    {
        String name = data.getKunde(vertrag.getKundenID()-1, true).getName();
        String vorname = data.getKunde(vertrag.getKundenID()-1, true).getVorname();
        int kundenid = vertrag.getKundenID();
        
        Auto auto = data.getAuto(vertrag.getAutoID()-1, true);
        
        String kfz = auto.getKennzeichen();
        String zweitfahrer = vertrag.getZweitfahrer();
        float tagessatz = auto.getTagessatz();
        Date abholtermin = vertrag.getAbholtermin();
        Date ruecktermin = vertrag.getRueckgabetermin();
        int vertragsnr = vertrag.getVertragsID();
        String marke = auto.getMarke();
        String modell = auto.getModell();       
        
      try {
      File file = new File("Vertrag.pdf");
      PDDocument document = PDDocument.load(file);
     
      
       
      PDPage page = document.getPage(0);
      PDPage page1 = document.getPage(1);
      PDPageContentStream content = new PDPageContentStream(document, page, true, true);
      PDPageContentStream content1 = new PDPageContentStream(document, page1, true, true);
      
      content.beginText(); 
      content1.beginText(); 
      
      content.moveTextPositionByAmount(150, 650);
      content.setFont(PDType1Font.TIMES_ROMAN, 16);
      content.drawString(vertragsnr+"");
      
      content.moveTextPositionByAmount(0, -45);
      content.setFont(PDType1Font.TIMES_ROMAN, 16);
      content.drawString(marke+" "+modell);
      
      content.moveTextPositionByAmount(290, 0);
      content.setFont(PDType1Font.TIMES_ROMAN, 16);
      content.drawString(kfz+"");
      
      content.moveTextPositionByAmount(-290, -70);
      content.setFont(PDType1Font.TIMES_ROMAN, 16);
      content.drawString(vorname+" "+name);
      
      content.moveTextPositionByAmount(320, 0);
      content.setFont(PDType1Font.TIMES_ROMAN, 16);
      content.drawString(kundenid+"");
      
      content.moveTextPositionByAmount(-150, -20);
      content.setFont(PDType1Font.TIMES_ROMAN, 16);
      content.drawString(zweitfahrer);
      
      content.moveTextPositionByAmount(-110, -45);
      content.setFont(PDType1Font.TIMES_ROMAN, 14);
      content.drawString(abholtermin+"");
      
      content.moveTextPositionByAmount(0, -25);
      content.setFont(PDType1Font.TIMES_ROMAN, 14);
      content.drawString(ruecktermin+"");
      
      
      content1.moveTextPositionByAmount(330, 765);
      content1.setFont(PDType1Font.TIMES_ROMAN, 14);
      content1.drawString(tagessatz+"");

     
      content.endText();
      content1.endText();

      System.out.println("PDF erstellt");

    
      content.close();
      content1.close();
      
    

      
      document.save(new File("Vertrag_"+vertragsnr+".pdf"));

     
      document.close();
      } catch (IOException e)
      {
          e.printStackTrace();
      }
   }
}
