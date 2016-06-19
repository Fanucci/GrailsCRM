package download

import com.CRM.User
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class UploadController {

    def index() {
            params.max = 30
        [contactInstanceList: Contact.list(params), contactInstanceTotal: Contact.count(), userList:User.getAll()]
    }

    def uploadfile() {

        TelCodes.getCodes()
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
        //    ExcelReaderInstance.setUser(getAuthenticatedUser())
        ExcelReaderInstance.setFileInputStream(fileStream)
        ExcelReaderInstance.readAll()

        }
        redirect (action:'index')
    }





}