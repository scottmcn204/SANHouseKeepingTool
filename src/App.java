import java.io.File;  
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class App {

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("test.xlsx"));  
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);  
        XSSFSheet sheet = workbook.getSheetAt(0);
        ArrayList<Port> reds = new ArrayList<Port>();
        ArrayList<Port> oranges = new ArrayList<Port>();
        ArrayList<Port> yellows = new ArrayList<Port>();
        for(Row row: sheet){
            if (row.getRowNum() != 0 && row.getRowNum() != 1){
                Port port = new Port();
                for(Cell cell: row){  
                    switch(cell.getColumnIndex()){
                        case 0: port.portA = cell.getStringCellValue();
                        break;
                        case 1: port.portNameA = cell.getStringCellValue();
                        break;
                        case 2: port.portB = cell.getStringCellValue();
                        break;
                        case 3: port.portNameB = cell.getStringCellValue();
                    }
                } 
                if (port.portNameA != null){
                    if(port.isRed()){
                        reds.add(port);
                    }
                    else if(port.isOrange()){
                        oranges.add(port);
                    }
                    else if(port.isYellow()){
                        yellows.add(port);
                    }
                } 
            }
        }
        System.out.println("--------------******(Red) The Following are most likely offline******--------------");  
        for(int i = 0; (i < reds.size()); i++){
            System.out.println(reds.get(i).portA + "\t" + reds.get(i).portNameA 
                + "\t" + reds.get(i).portB + "\t" + reds.get(i).portNameB);
        }
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-----------******(Orange) The Following are most likely Disabled******---------------");  
        for(int i = 0; (i < oranges.size()); i++){
            System.out.println(oranges.get(i).portA + "\t" + oranges.get(i).portNameA 
                + "\t" + oranges.get(i).portB + "\t" + oranges.get(i).portNameB);
        }
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("----------******(Yellow) The Following are most likely Missing Alias******------------");  
        for(int i = 0; (i < yellows.size()); i++){
            System.out.println(yellows.get(i).portA + "\t" + yellows.get(i).portNameA 
                + "\t" + yellows.get(i).portB + "\t" + yellows.get(i).portNameB);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }  
}  
