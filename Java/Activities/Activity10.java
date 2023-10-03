package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String args[]){
        HashSet<String> hs=new HashSet<String>();
        hs.add("sushma");
        hs.add("sudhir");
        hs.add("Ravi");
        hs.add("sushma");
        hs.add("test");
        hs.add("sushma");
        System.out.println("Number of elements in hasset is: "+hs.size());

            System.out.println(hs);
            hs.remove("sudhir");
        System.out.println(hs);

    }
}
