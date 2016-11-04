package teste;

import controller.UsuarioJpaController;
import entities.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class testeCriar {

    private static final String fileName = "C://novo.xls";

    public static void criarExcel() throws IOException, ParseException {
        //é criar o arquivo
        HSSFWorkbook workbook = new HSSFWorkbook();
        //criar a planilha
        HSSFSheet sheetAlunos = workbook.createSheet("Alunos");

        //Criar lista das classe de entidade Usuario
        Usuario usu = new Usuario();
        UsuarioJpaController usuJPA = new UsuarioJpaController();
        List<Usuario> lista = usuJPA.findUsuarioEntities();

        //Cria as celulas no arquivo
        int rownum = 0;
        for (Usuario usu1 : lista) {
            Row row = sheetAlunos.createRow(rownum++);
            int cellnum = 0;

            Cell nome = row.createCell(cellnum++);
            nome.setCellValue(usu1.getNomeUsu());
        }try {
            FileOutputStream out = new FileOutputStream(new File(testeCriar.fileName));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Arquivo não encontrado!");

        }
    }
}
