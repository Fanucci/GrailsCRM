package download

class FilterController {

    def index() { }

    def addfilter(){
           def checkedUsers = params.list('myCheckbox')
    println checkedUsers.size()
    def selectedUsers = Contact.getAll(checkedUsers)
    def filt=new Filter("name")
    filt.addContactfield(new ContactField())


    }





}
