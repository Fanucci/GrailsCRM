package download

class UserSettings {
static List<ContactField> defaultContactFields = Arrays.asList(
new ContactField("phone",0,ContactField.Type.PHONE),
new ContactField("dateInquiry",1,ContactField.Type.DATE),
new ContactField("2time",2,ContactField.Type.TIME),
new ContactField("IP",3,ContactField.Type.TEXT),
new ContactField("promo",4,ContactField.Type.TEXT),
new ContactField("referal",6,ContactField.Type.TEXT),
//new ContactField("dateActive",7,ContactField.Type.DATE),
new ContactField("UTC",8,ContactField.Type.TEXT),
new ContactField("region",9,ContactField.Type.TEXT),
new ContactField("status",10,ContactField.Type.TEXT)
);

    public static List<ContactField> getUserFieldSettings(){return defaultContactFields}
    
    
/*List<ContactField> defaultContactFields() {
    new ContactField(phone,0,NUMBER)
}*/
    static constraints = {

    }
}
