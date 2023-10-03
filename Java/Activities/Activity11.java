package Activities;

import java.util.HashMap;

public class Activity11 {
    public static void main (String args[]){
        HashMap<Integer,String> hm=new HashMap<>();
        hm.put(1,"Blue");
        hm.put(2,"Red");
        hm.put(0,"Yellow");
        hm.put(1,"pink");
        System.out.println(hm);
        hm.remove(1);
        System.out.println(hm);
        hm.remove(1,"Red");
        System.out.println(hm);
        System.out.println(hm.containsValue("Yellow"));
        System.out.println("Number of pairs in the Map is: " + hm.size());
    }
}
