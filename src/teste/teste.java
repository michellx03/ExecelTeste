package teste;

import controller.UsuarioJpaController;
import entities.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class teste {
  
    public void criar(){
        Usuario usu = new Usuario();
        UsuarioJpaController usuJPA = new UsuarioJpaController();
        
        usu.setNomeUsu("Fernando");
        usu.setIdadeUsu(21);
        usuJPA.create(usu);
        System.out.println("Gravado com sucesso!");
    }
    
    public void ler(){
        Usuario usu = new Usuario();
        UsuarioJpaController usuJPA = new UsuarioJpaController();
        List<Usuario> lista = usuJPA.findUsuarioEntities();
        
        for(Usuario usu1 : lista){
            System.out.println(usu1.getNomeUsu());
            System.out.println(usu1.getIdadeUsu());
        }       
    }
    
    private static String fileName = "C:\\ler.xls";
    
    public static void lerExcel() throws IOException, ParseException{
        
        try{
            FileInputStream file = new FileInputStream(new File(teste.fileName));
            
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheetAlunos = workbook.getSheetAt(0);
            
            //Linha de Arquivos
            Iterator<Row> rows = sheetAlunos.rowIterator();
            
            //Executa enquato linhas exisitir
            while(rows.hasNext()){
                HSSFRow row = (HSSFRow) rows.next();
                
                //cell navegalao das colunas
                Iterator<Cell> cells = row.cellIterator();
                while(cells.hasNext()){
                    HSSFCell cell = (HSSFCell) cells.next();
                    //System.out.println(cell);
                    
                    //Para gravar dados no banco
                    for (int rowIndex = 1; rowIndex<=4; rowIndex++){
                        HSSFRow row2 = sheetAlunos.getRow(rowIndex);
                        
                        Cell nome = row2.getCell(0);
                        String nome1 = nome.toString();
                        
                        Cell idade = row2.getCell(1);
                        int idade1 = (int) idade.getNumericCellValue();
                        
                        //Metodo para criar
                        Usuario usu = new Usuario();
                        UsuarioJpaController usuJPA = new UsuarioJpaController();

                        usu.setNomeUsu(nome1);
                        usu.setIdadeUsu(idade1);
                        usuJPA.create(usu);
                        System.out.println("Importado com sucesso!");
                    }   break;   
                }   break;
            }
        }catch (IOException ex){
            
        }
    }
}
