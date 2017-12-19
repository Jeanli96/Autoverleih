/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import GUI.OptionsStage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class Stream {

    public String read() throws FileNotFoundException {
        FileInputStream fis = null;
        String loginData = "old_Data";
        try {
            fis = new FileInputStream("options.ini");

            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
                loginData = (String) ois.readObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return loginData;
    }

    public void write(String loginData) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("options.ini");
            ObjectOutputStream oos = null;

            try {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(loginData);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (oos != null) {
                        oos.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
