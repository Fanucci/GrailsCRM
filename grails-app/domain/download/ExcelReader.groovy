package download

import com.CRM.User
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
    User user
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
    public setUser(User u){
        this.user=u
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
                v=String.valueOf(String.valueOf((int)v))
                /* if(v instanceof Double){

                }*/
            }
            if(cell.getCellType()==Cell.CELL_TYPE_STRING){
                v = cell.getStringCellValue();
            }
        }
        return v;
    }

    def readRow(){
        def cont = new Contact()


        cont.save()
        cont.addBlankContactFields()
        def NBF = cont.contactfields
        for (ContactField CF:NBF){
        def cell2=row.getCell(CF.getFieldTablePosition())
        boolean isDate= false
        if(cell2!=null&&cell2.getCellType()==Cell.CELL_TYPE_NUMERIC){isDate=HSSFDateUtil.isCellDateFormatted(cell2)}
            cell = readCellValue(CF.getFieldTablePosition());
            if(cell!=null){
            if (CF.getFieldType()==ContactField.Type.PHONE){
                cell=cell2
                String value = new DecimalFormat("#.#######################").format(cell.getNumericCellValue());
                //    System.out.println("["+value+"]");
                CF.setFieldProperty(value)
            }
            else if ((CF.getFieldType()==ContactField.Type.TIME)&&isDate){
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String shortTimeStr = sdf.format(cell);
                CF.setFieldProperty(shortTimeStr);
            }
            else if ((CF.getFieldType()==ContactField.Type.DATE)&&isDate){
                String date = new SimpleDateFormat("dd-MM-yyyy").format(cell);
                CF.setFieldProperty(date);
            }
            else if(CF.getFieldName()=="IP"){
                if(Character.getType(cell.charAt(cell.length()-1))==Character.DIRECTIONALITY_WHITESPACE){
                    CF.setFieldProperty(cell.substring(0, cell.length()-3))
                }
                else CF.setFieldProperty(cell)
            }
            else{
                CF.setFieldProperty(cell)
            }
}
            CF.transformNulls()

            //  println(CF.getFieldName())
        }
        cont.owner=user
        //    cont.save(flush:true)
        cont.save()
        System.out.println(cont.contactfields[0].getFieldName()+" = "+cont.contactfields[0].getFieldProperty())
    }

    def readAll(){

        while(rowIterator.hasNext()){row = rowIterator.next();readRow();}
        println "done"
        workbook.close()
    }

    def writeContactRow(Contact cont){
        for(ContactField CFs:cont.contactfields){
            if((CFs.getFieldProperty()!=null)&&(CFs.getFieldTablePosition()!=null)){
                if (CFs.getFieldName()=="region"){                          //temp
                    cell= row.createCell(CFs.getFieldTablePosition())
                    def ddd=TelCodes.checkNumber(cont.getPropertyOf("phone"))
                    cell.setCellValue(ddd);
                }                                                           //temp
                else{
                    cell= row.createCell(CFs.getFieldTablePosition())
                    cell.setCellValue(CFs.getFieldProperty());

                }
                if(CFs.getFieldType()==(ContactField.Type.PHONE||ContactField.Type.NUMBER))cell.setCellType(Cell.CELL_TYPE_NUMERIC)
            }
        }

    }

    def writeAllContactRow(){
        def contList = Contact.findAllByOwner(user)
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
