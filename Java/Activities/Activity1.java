package Activities;


class Car{
    String color="Black";
    String transmission="Automatic";
    int make= 2014;
    int tyres;
    int doors;
    Car(){
        tyres=4;
        doors=4;
    }
    public void displayCharacteristics(){
        System.out.println("Characteristics of Car:");
        System.out.println("color:" + color);
        System.out.println("transmission:"+ transmission);
        System.out.println("Make:"+make);
        System.out.println("Tyres:"+tyres);
        System.out.println("Doors:"+doors);
    }
    void accelarate(){
        System.out.println("Car is moving forward");

    }
    void brake(){
        System.out.println("Car has stopped");
    }

}

public class Activity1 {
    public static void main(String[] args){
      Car obj=new Car();
      obj.displayCharacteristics();
      obj.accelarate();
      obj.brake();

    }
}
