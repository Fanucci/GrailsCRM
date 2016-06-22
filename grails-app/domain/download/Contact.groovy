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

    public String getOwnerUsername(){
        if (owner==null)return null
        return this.owner.username
    }

    public String getPropertyOf(String name){
        for(ContactField CFs:this.contactfields){
            if(CFs.getFieldName()==name) return CFs.getFieldProperty()
        }
        return "-"
    }

    public static List<Contact> getAllContactsWithSubstring(String ss){
        List<Contact> contactList= new ArrayList<Contact>()

        def s=ContactField.findAllByPropertyLike('%%'+ss+'%%')
        println s.size()
        for(ContactField c:s)contactList.add(c.contact)
       /* def cont
        for(Contact c:Contact.getAll()){
            cont=c
        for(ContactField cf:c.contactfields){
        if(cf.getFieldProperty().toLowerCase().contains(ss.trim().toLowerCase()))contactList.add(cont)
        }
        }*/
return contactList
    }



    static constraints = {
        contactfields(nullable:true)
        owner(nullable:true)
    }
}
