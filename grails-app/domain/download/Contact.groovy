package download

class Contact {
    def listOfFields
    ContactField CF,CF1,CF2,CF3,CF4,CF5,CF6,CF7,CF8,CF9,CF10,CF11,CF12,CF13,CF14,CF15,CF16,CF17,CF18,CF19,CF20
    int size
    List<ContactField> CFList

        
public Contact(){
listOfFields = UserSettings.getUserFieldSettings()
size=listOfFields.size()
    addCFtoList(size, CF,CF1,CF2,CF3,CF4,CF5,CF6,CF7,CF8,CF9,CF10,CF11,CF12,CF13,CF14,CF15,CF16,CF17,CF18,CF19,CF20)
   /* int i=0
    Iterator<String> crunchifyIterator = CFList.iterator();
    while (crunchifyIterator.hasNext()) {
        crunchifyIterator.next()=listOfFields.get(i)
        i++
    }
*/
    println(CF.getFieldName())
}

   public addCFtoList(int i,ContactField...v){
        CFList = new ArrayList<ContactField>()
        int z=0
       for (ContactField x:v){
        if(i>0){
            x=listOfFields.get(z)
                CFList.add(x);
            z++
            i--
        }}

   }
   
   public List<ContactField> getNewBaseFields(){return CFList}

 /*  def dynamicProperties= [:]
   //setter
   def propertyMissing(String name, value) { dynamicProperties[name] = value }
   //getter
   def propertyMissing(String name) { dynamicProperties= [name] }
   
        def writeContactFields(){
    for(ContactField CF:listOfFields){
        this."ip${CF.getFieldName()}" = CF.getFieldProperty()
    }
}*/

    static constraints = {
    }
}
