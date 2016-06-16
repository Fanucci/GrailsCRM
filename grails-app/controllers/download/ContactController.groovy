package download

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class ContactController {

    def index() { 
        params.max = 10
        [contactInstanceList: Contact.list(params), contactInstanceTotal: Contact.count()]
    }
    def doNothing() {
   /*   def a = new User(login: "iskandarova", pass: "kotiki").save()
      def b = new User(login: "luzenin", pass: "parol").save()
      def c = new User(login: "sda00", pass: "Zxcasd123").save()*/
    }
    
        def downloads(long id) {
        Document documentInstance = Document.get(id)
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")
            def file = new File(documentInstance.fullPath)
            def fileInputStream = new FileInputStream(file)
            def outputStream = response.getOutputStream()
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fileInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush()
            outputStream.close()
            fileInputStream.close()
        
    }
            def download() {
                def XLS= new ExcelReader()
                XLS.initialize()
                XLS.writeAllContactRow()
                def FOS= new FileInputStream(XLS.saveFile())
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"haha.xlsx\"")
            response.outputStream<<FOS
            response.outputStream.flush()
            response.outputStream.close()
            FOS.close()
        return
    }
    
    
}
