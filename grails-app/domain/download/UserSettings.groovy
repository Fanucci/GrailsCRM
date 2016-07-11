package download

class UserSettings {
static List<ContactField> defaultContactFields = Arrays.asList(
new ContactField("Телефон",0,ContactField.Type.PHONE),
new ContactField("Дата запроса",1,ContactField.Type.DATE),
new ContactField("Время активации",2,ContactField.Type.TIME),
new ContactField("IP",3,ContactField.Type.TEXT),
new ContactField("Промокод",4,ContactField.Type.TEXT),
new ContactField("Кто привел",6,ContactField.Type.TEXT),
new ContactField("Активация",7,ContactField.Type.TEXT),
new ContactField("UTC",8,ContactField.Type.TEXT),
new ContactField("Регион",9,ContactField.Type.TEXT),
new ContactField("Статус",10,ContactField.Type.TEXT)
);

    public static List<ContactField> getUserFieldSettings(){return defaultContactFields}
    
    
/*List<ContactField> defaultContactFields() {
    new ContactField(phone,0,NUMBER)
}*/
    static constraints = {

    }
}
