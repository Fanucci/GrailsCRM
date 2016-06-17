package download

import au.com.bytecode.opencsv.CSVReader;

class TelCodes {
int ABCDEF
int numFrom
int numTo
//String operator
String region

    def static getCodes(){
          CSVReader reader = new CSVReader(new FileReader("C:/Personal Soft/grails-3.1.6/WebRegions/Kody_DEF-9kh.csv"),(char) ';');
       
     String [] nextLine;
  reader.readNext();
     while ((nextLine = reader.readNext()) != null) {
         def TelCodesInst = new TelCodes();
         TelCodesInst.ABCDEF= Integer.parseInt(nextLine[0]);
         TelCodesInst.numFrom= Integer.parseInt(nextLine[1]);
         TelCodesInst.numTo= Integer.parseInt(nextLine[2]);
        // TelCodesInst.operator= nextLine[4];
         TelCodesInst.region= nextLine[5];
         TelCodesInst.save()
     }
        
    }
    def static String checkNumber(String num){
         int dig3 = Integer.parseInt(num.substring(1,4));
            int dig7 = Integer.parseInt(num.substring(4,11));
            def TelCodes1 = TelCodes.getAll();
            for(TelCodesInst in TelCodes1){
                
            System.out.println(dig3+":::"+TelCodesInst.ABCDEF);
            if (dig3.equals(TelCodesInst.ABCDEF)){  		 
            if(dig7>TelCodesInst.numFrom) {   	
            if( dig7<TelCodesInst.numTo){
          //  System.out.println(TelCodesInst.region);
            return TelCodesInst.region;
            }}}}}
    
    static constraints = {
    }
}
