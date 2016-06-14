package download

import java.lang.reflect.Field

class ContactField {
String name
String property
int tablePosition
Type sd
public enum Type {TEXT, NUMBER, DATE, TIME, PHONE}
public ContactField(String n,int tp){
    this.name=n
    this.tablePosition=tp

}
    
public ContactField(String n,int tp, Type t){
    this.name=n
    this.tablePosition=tp
    this.sd=t
}
public ContactField(String n,String p,int tp,Type t){
    this.name=n
    this.property=p
    this.tablePosition=tp
    this.sd=t
}
public copyObjectParams(ContactField CFs){
        this=CFs
}
    
public String getFieldName(){return this.name}
public void setFieldName(String name){this.name=name}
    
public String getFieldProperty(){return this.property}
public void setFieldProperty(String property){this.property=property}
    
public int getFieldTablePosition(){return this.tablePosition}
public void setFieldTablePosition(int tablePosition){this.tablePosition=tablePosition}

public Type getFieldType(){return this.sd}
public void setFieldType(Type sd){this.sd=sd}
    static constraints = {
    }
}
