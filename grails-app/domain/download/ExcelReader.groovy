package download
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFDateUtil

class ExcelReader {
    String filename
    String fullPath
    
    def createHelper
    def workbook;
    def sheet;
    def hlink_style;
    def rowIterator;
    def cell;
    def row;
   // ContactSettings sett;
    
    public setFileInputStream(FileInputStream fileStream){

        FileInputStream file = (FileInputStream)fileStream;   
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheetAt(0);
        def rowsQ=sheet.getPhysicalNumberOfRows();
        rowIterator = sheet.iterator();
        System.out.println("Total rows:" + rowsQ);
        System.out.println("Total columns:" + sheet.getRow(0).getPhysicalNumberOfCells());
    }
    
    def readCellValue(int n){
        def v;
        cell = row.getCell(n);
        if(cell!=null){
            if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    v = cell.getDateCellValue();
                    return v;
                }
                v = cell.getNumericCellValue();
                if(v instanceof Double){
                    v=String.valueOf(v);
                }
            }   
            if(cell.getCellType()==Cell.CELL_TYPE_STRING){
                v = cell.getStringCellValue();
            }
     }
        return v;
    }
    
    def readRow(){
        def cont = new Contact()
        def NBF = cont.getNewBaseFields()
        for (ContactField CF:NBF){
            cell = readCellValue(CF.getFieldTablePosition());
            if (CF.getFieldType()==ContactField.Type.PHONE){
            cell=row.getCell(CF.getFieldTablePosition())
            String value = new DecimalFormat("#.#######################").format(cell.getNumericCellValue());
            System.out.println("["+value+"]");
            CF.setFieldProperty(value)
            }
            else if (CF.getFieldType()==ContactField.Type.TIME){
            CF.setFieldProperty(cell.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
            }
            else if (CF.getFieldType()==ContactField.Type.DATE){
            CF.setFieldProperty(LocalDateTime.ofInstant(Instant.ofEpochMilli(cell.getTime()), ZoneOffset.ofHours(+5)).toString());
            }
            else{
            CF.setFieldProperty(cell)
            }

        }
        cont.save()
        println(cont)
    }
    
    def readAll(){
        
    while(rowIterator.hasNext()){row = rowIterator.next();readRow();}
    }
    
    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }
}
