package download

class Contact {
    def listOfFields
    ContactField CF,CF1,CF2,CF3,CF4,CF5,CF6,CF7,CF8,CF9,CF10,CF11,CF12,CF13,CF14,CF15,CF16,CF17,CF18,CF19,CF20
    int size
    List<ContactField> CFList
   def dynamicProperties= [:]
   //setter
   def propertyMissing(String name, value) { dynamicProperties[name] = value }
   //getter
   def propertyMissing(String name) { dynamicProperties= [name] }
        
public Contact(){
listOfFields = UserSettings.getUserFieldSettings()
size=listOfFields.size()
    addCFtoList(size)
    int i=0
    for (ContactField ContF:CFList){
        ContF=listOfFields.get(i)
        println(ContF.getFieldName()+" = "+listOfFields.get(i).getFieldName())
        i++
    }
}

   public addCFtoList(int i){
       CFList = new ArrayList<ContactField>()
       Collections.addAll(CFList, CF,CF1,CF2,CF3,CF4,CF5,CF6,CF7,CF8,CF9,CF10,CF11,CF12,CF13,CF14,CF15,CF16,CF17,CF18,CF19,CF20);
       int s=CFList.size()
       for(int x=i;x<s;x++)CFList.remove(i)
   }
   
   public List<ContactField> getNewBaseFields(){return CFList}

 /*   def writeContactFields(){
    for(ContactField CF:listOfFields){
        this."ip${CF.getFieldName()}" = CF.getFieldProperty()
    }
}*/

    static constraints = {
    }
}
