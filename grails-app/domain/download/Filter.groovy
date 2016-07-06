package download

class Filter {
String name
ContactField ContactField
/*
date  11.04.13_14.07.15
number  5000_8000
TEXT  elepho

    */
       public Filter(String name){
           this.name=name
    }
public addContactfield(ContactField ncf){
        this.addToContactfields(ncf).save()
}

static hasMany = [contactfields: ContactField]

    static constraints = {
    }
def List<Contact> getFilteredContactList(){
    List<Contact> contactList= new ArrayList<Contact>()
def c = ContactField.createCriteria()
def results = c {
    for(ContactField CFs:this.contactfields){
        and {
    ilike("name",CFs.getFieldName())
    if(CFs.getFieldType()==ContactField.Type.TEXT){
    ilike("property", '%%'+CFs.getFieldProperty()+'%%')
    }
    else if(CFs.getFieldType()==ContactField.Type.NUMBER){
        if (CFs.getFieldProperty().contains("_")) {
            String[] parts = CFs.getFieldProperty().split("_");
            between("property", parts[0], parts[1])
        }
    else{
        eq("property", CFs.getFieldProperty())
    }

    }
    else if(CFs.getFieldType()==ContactField.Type.DATE){

    }
        }
    }
    maxResults(10)
   // order("holderLastName", "desc")
}
return contactList

}

}
