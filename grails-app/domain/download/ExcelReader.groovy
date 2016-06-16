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
import org.apache.poi.hssf.usermodel.HSSFWorkbook

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
            CF.transformNulls()
          //  println(CF.getFieldName())
        }
    //    cont.save(flush:true)
cont.save()
    }
    
    def readAll(){
        
    while(rowIterator.hasNext()){row = rowIterator.next();readRow();}
    workbook.close()
    }
    
    def writeContactRow(Contact cont){
        for(ContactField CFs:cont.getNewBaseFields()){
            if((CFs.getFieldProperty()!=null)&&(CFs.getFieldTablePosition()!=null)){
               cell= row.createCell(CFs.getFieldTablePosition())
               cell.setCellValue(CFs.getFieldProperty());
            }
        }
    }
    
    def writeAllContactRow(){
        def contList = Contact.getAll()
        int i=0;
        for (Contact cont:contList){
            row = sheet.createRow(i)
            writeContactRow(cont);
            i++}
    }
    public File saveFile(){
        def file= new File("b.xlsx")
    FileOutputStream fileOut = new FileOutputStream(file);
    workbook.write(fileOut);
    return file;
    }
    

    
    def initialize(){
            workbook= new XSSFWorkbook();
    sheet = workbook.createSheet("new sheet");
    }
    
    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }
}
