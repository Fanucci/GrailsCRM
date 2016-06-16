package download
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class UploadController {

    def index() {
            params.max = 10
        [contactInstanceList: Contact.list(params), contactInstanceTotal: Contact.count()]
    }

    def uploadfile() {
        def file = request.getFile('file')
        if(file.empty) {
            flash.message = "File cannot be empty"
        } else {
            def ExcelReaderInstance = new ExcelReader()
            ExcelReaderInstance.filename = file.originalFilename
            ExcelReaderInstance.fullPath = grailsApplication.config.uploadFolder + ExcelReaderInstance.filename
           /* file.transferTo(new File(jobInstance.fullPath))
            jobInstance.save()*/
            String path = "c:/Data/"+ExcelReaderInstance.filename
            InputStream fileStream = file.getInputStream() 
            println(path)
        ExcelReaderInstance.setFileInputStream(fileStream)
        ExcelReaderInstance.readAll()

        /*def Contactlist = Contact.getAll()
        println(Contactlist.size())
        for(Contact c:Contactlist){
        println(c.getCF().getFieldProperty())
        }
       */
        }
        redirect (action:'index')
    }
   /*def getPropertyOf(String name){
       for(ContactField CFs:this.getNewBaseFields()){
           if(CFs.getFieldName()==name) return CFs.getFieldProperty()
       }
       [variableNameInGSP : valueToBeReturned]
   }*/
   
}