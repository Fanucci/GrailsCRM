package download
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.multipart.commons.CommonsMultipartFile
@Secured('ROLE_USER')
class DocumentController {

    static allowedMethods = [save: "POST"]

    def index() {

    }

    }