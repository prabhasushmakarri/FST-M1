package Activities;



abstract class book{
    String title;
    abstract void setTitle(String st);
    public String getitle(){
        return title;
    }

}
 class Mybook extends book {
    public void setTitle(String s){
        title=s;
    }
}

public class Activity5 {
    public static void main(String[] args){
        Mybook obj=new Mybook();
        obj.setTitle("Selenium");
        System.out.println(obj.getitle());
    }
}
