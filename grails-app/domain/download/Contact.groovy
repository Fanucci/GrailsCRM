package download
import com.CRM.User
import grails.plugin.springsecurity.SpringSecurityService

class Contact {
    List contactfields
    User owner
    static hasMany = [contactfields: ContactField]
    public Contact(){
    }
    public addBlankContactFields(){
        def sett= UserSettings.getUserFieldSettings()
        for (ContactField CF:sett){
            def ncf=new ContactField()
            ncf.copyObjectParams(CF)
            this.addToContactfields(ncf).save()
        }
    }

    public String getPropertyOf(String name){
        for(ContactField CFs:this.contactfields){
            if(CFs.getFieldName()==name) return CFs.getFieldProperty()
        }
        return "-"
    }


    def beforeValidate() {

    }

    static constraints = {
        contactfields(nullable:true)
        owner(nullable:true)
    }
}
