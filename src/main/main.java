package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import teste.teste;
import teste.testeCriar;

public class main {
    public static void main (String []args) throws IOException{
        try {
            //teste ti = new teste();
            //ti.criar();
            //ti.ler();
            //teste.lerExcel();   
            
            testeCriar to = new testeCriar();
            testeCriar.criarExcel();
            
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
