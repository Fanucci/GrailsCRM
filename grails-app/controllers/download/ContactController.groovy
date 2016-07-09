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
    def it=Contact.findAllByOwner(null).listIterator()
    while(it.hasNext()){
    for (User u:selectedUsers){
        if(it.hasNext()){
        def cont=it.next()
        cont.owner=u
        cont.save()
        }
    }
    }
    return ''
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
        return ''
    }
def findContact(){
def input= params.search
println input
List<Contact> cl=Contact.getAllContactsWithSubstring(input)
[contactInstanceList: cl, contactInstanceTotal: cl.size()]
}

  def showContactCard(){
      println params.id
      def contactfields = Contact.get(params.id).contactfields
      [contactfieldsList: contactfields]
      render(view: "ContactCard")
  }  

}
