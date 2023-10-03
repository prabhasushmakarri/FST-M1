package Activities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxpassengers;
    private Date lastTimeTookof;
    private Date lastTimelanded;
    Plane(int maxpass){
        maxpassengers=maxpass;
        this.passengers=new ArrayList<>();
    }
    public void onboard(String pass){
        this.passengers.add(pass);
    }
    public Date takeoff(){
        lastTimeTookof=new Date();
        return lastTimeTookof;
    }
    public void land(){
        lastTimelanded=new Date();

    }
    public Date getlastimelanded(){
        return lastTimelanded;
    }

    public List<String> getpassengers(){
        return this.passengers;
    }
}

public class Activity6 {

    public static void main(String args[]) throws InterruptedException {
        Plane obj=new Plane(5);
        obj.onboard("sushma");
        obj.onboard("sudhir");
        obj.onboard("Ravi");
        obj.onboard("sagar");
        obj.onboard("Vikas");
        System.out.println("Flight take off time" + obj.takeoff());
        System.out.println("Passengers names in flight" +obj.getpassengers());
        Thread.sleep(5000);
        obj.land();
        System.out.println("Flight landing time"+obj.getlastimelanded());




    }
}
