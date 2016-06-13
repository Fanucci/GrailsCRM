package download

class UploadController {

    def index() { }

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
        }
        redirect (action:'index')
    }
}