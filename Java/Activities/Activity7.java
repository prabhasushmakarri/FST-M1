package Activities;

interface BicycleParts{
    public int gears=10;
    public int speed=0;
}

interface BicycleOperations{
public void applybreak(int speedlow);
public void speedup(int speedup);
}
class cycle implements BicycleParts,BicycleOperations{
    int currentspeed;
    public int gears;
    cycle(int gears,int speed){
        this.gears=gears;
        currentspeed=speed;
    }
    public void applybreak(int speed){

        currentspeed=currentspeed-speed;

    }
    public void speedup(int speed){

        currentspeed=currentspeed+speed;


    }
public void bicycledesc(){
        System.out.println("No of gears:"+ gears);
        System.out.println("current speed of bicycle:"+currentspeed);
}
}
class mountainbike extends cycle{
    int seatheight;
   public mountainbike(int gears,int currentspeed,int seatheight) {
        super(gears, currentspeed);
        this.seatheight=seatheight;
    }
    void seatheight(int seatheight){
     this.seatheight=seatheight;
    }
    void setSeatheight(){
        System.out.println("seat of moutainbicycle is:"+seatheight);
    }
}
public class Activity7
{
    public static void main(String args[]){
        mountainbike obj=new mountainbike(2,15,2);
        obj.bicycledesc();
        obj.speedup(20);
        obj.applybreak(10);
        System.out.println("current speed of cycle after applying breaks");
        obj.bicycledesc();


    }
}
