package Activities;

class customexception extends Exception{
    private String msg=null;
    public customexception(String msg){
        this.msg=msg;
    }
    public String getmessage(){
        return msg;
    }
}
public class Activity8 {
public static void main (String args[]){

    try{
        Activity8.exceptionTest("Will print to console");
         Activity8.exceptionTest(null); // Exception is thrown here
        Activity8.exceptionTest("Won't execute");
    }
    catch(customexception mae){
        System.out.println("Inside catch block: " + mae.getmessage());
    }
}
    static void exceptionTest(String str) throws customexception {
        if(str == null) {
            throw new customexception("String value is null");
        } else {
            System.out.println(str);
        }
    }
}
