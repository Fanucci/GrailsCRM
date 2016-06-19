package download

import com.CRM.User
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_USER')
class ContactController {

    def index() {
        params.max = 30
        [contactInstanceList: Contact.list(params), contactInstanceTotal: Contact.count()]
    }
@Secured('ROLE_ADMIN')
def divideBase(){
    def checkedUsers = params.list('myCheckbox')
    println checkedUsers.size()
    def selectedUsers = User.getAll(checkedUsers)
    println selectedUsers.get(0)
    def it=Contact.getAll().listIterator()
    while(it.hasNext()){
    for (User u:selectedUsers){
        if(it.hasNext()){
        def cont=it.next()
        println cont
        println u
        cont.owner=u
        cont.save()
        }
    }
    }
    redirect(controller: "upload", action: "index")
}

            def download() {
                def XLS= new ExcelReader()
                XLS.initialize()
                XLS.setUser(getAuthenticatedUser())
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
def findContact(){
params.search
}

}
