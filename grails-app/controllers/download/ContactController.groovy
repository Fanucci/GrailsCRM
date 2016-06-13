package download

class ContactController {

    def index() { 
        params.max = 10
        [contactInstanceList: Contact.list(params), contactInstanceTotal: Contact.count()]
    }
}
