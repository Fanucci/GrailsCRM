package download

import au.com.bytecode.opencsv.CSVReader;

class TelCodes {
    int ABCDEF
    int numFrom
    int numTo
    String region

    def static getCodes(){
        CSVReader reader = new CSVReader(new BufferedReader(new FileReader("C:/Users/Dmitry Sorokin/Documents/NetBeansProjects/GrailsCRM1/Kody.csv")),(char) ';');
        String [] nextLine;
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            def TelCodesInst = new TelCodes();
            TelCodesInst.ABCDEF= Integer.parseInt(nextLine[0]);
            TelCodesInst.numFrom= Integer.parseInt(nextLine[1]);
            TelCodesInst.numTo= Integer.parseInt(nextLine[2]);
            TelCodesInst.region= nextLine[3];
            TelCodesInst.save(validate:false)
        }
        
    }
    def static String checkNumber(String num){
        int dig3 = Integer.parseInt(num.substring(1,4));
        int dig7 = Integer.parseInt(num.substring(4,11));
        //   def TelCodes1 = TelCodes.getAll();
        def results = TelCodes.find {
            ABCDEF == dig3
            numFrom<dig7
            numTo>dig7
        }
        println results.region
        return results.region
    }
    
    static constraints = {
    }
}
