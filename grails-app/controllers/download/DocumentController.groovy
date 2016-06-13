package download
import org.springframework.web.multipart.commons.CommonsMultipartFile
class DocumentController {

    static allowedMethods = [save: "POST"]

    def index() {
      
    }
    def uploadf() {
            def fileName
        def inputStream
        if (params.qqfile instanceof CommonsMultipartFile) {
            fileName = params.qqfile?.originalFilename
            inputStream = params.qqfile.getInputStream()
        } else {
            fileName = params.qqfile
            inputStream = request.getInputStream()
        }
        //To avoid problems with spaces
        fileName = fileName.replaceAll(" ", "_")
 
        File storedFile = new File(_some_specfic_path_)
 
        storedFile.append(inputStream)
 
    }
    }