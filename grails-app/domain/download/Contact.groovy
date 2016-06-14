package download

class Contact {
    def listOfFields
    ContactField CF,CF1,CF2,CF3,CF4,CF5,CF6,CF7,CF8,CF9,CF10,CF11,CF12,CF13,CF14,CF15,CF16,CF17,CF18,CF19,CF20
    int size
    List<ContactField> CFList
    static hasMany = [contactfields: ContactField]
public Contact(){
listOfFields = UserSettings.getUserFieldSettings()
size=listOfFields.size()
CF= new ContactField()
CF1= new ContactField()
CF2= new ContactField()
CF3= new ContactField()
CF4= new ContactField()
CF5= new ContactField()
CF6= new ContactField()
CF7= new ContactField()
CF8= new ContactField()
CF9= new ContactField()
CF10= new ContactField()
CF11= new ContactField()
CF12= new ContactField()
CF13= new ContactField()
CF14= new ContactField()
CF15= new ContactField()
CF16= new ContactField()
CF17= new ContactField()
CF18= new ContactField()
CF19= new ContactField()
CF20= new ContactField()
    addCFtoList(size, CF,CF1,CF2,CF3,CF4,CF5,CF6,CF7,CF8,CF9,CF10,CF11,CF12,CF13,CF14,CF15,CF16,CF17,CF18,CF19,CF20)
    
    int i=0
    Iterator<String> crunchifyIterator = CFList.iterator();
    while (crunchifyIterator.hasNext()) {
        crunchifyIterator.next().copyObjectParams(listOfFields.get(i))
        i++
    }
}

   public addCFtoList(int i,ContactField...v){
        CFList = new ArrayList<ContactField>()
        int z=0
       for (ContactField x:v){
      //     x=new ContactField()
        if(i>0){
         //   x=listOfFields.get(z)
                CFList.add(x);
            z++
            i--
        }}

   }
   public ContactField getCF(){
       return CF
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
        contactfields(nullable:true)
        /*CF (nullable: true)
        CF1 (nullable: true)
        CF2 (nullable: true)
        CF3 (nullable: true)
        CF4 (nullable: true)
        CF5 (nullable: true)
        CF6 (nullable: true)
        CF7 (nullable: true)
        CF8 (nullable: true)
        CF9 (nullable: true)
        CF10 (nullable: true)
        CF11 (nullable: true)
        CF12 (nullable: true)
        CF13 (nullable: true)
        CF14 (nullable: true)
        CF15 (nullable: true)
        CF16 (nullable: true)
        CF17 (nullable: true)
        CF18 (nullable: true)
        CF19 (nullable: true)
        CF20 (nullable: true)*/
    }
}
