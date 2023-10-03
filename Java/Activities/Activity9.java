package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
public static void main(String args[]) {
    ArrayList<String> myList = new ArrayList<String>();
    myList.add("sushma");
    myList.add("sudhir");
    myList.add("Ravi");
    myList.add(3,"Vikas");
    myList.add("prabha");
    System.out.println("Names in the List:");
    for(int i=0;i< myList.size();i++){
        System.out.println(myList.get(i));
    }
    System.out.println("Third name in the list"+myList.get(2));
    System.out.println(myList.contains("sushma"));
    System.out.println("Size of list is:"+myList.size());
    myList.remove("Vikas");

    System.out.println(myList.contains("Vikas"));
    System.out.println("Size of list is:"+myList.size());
    System.out.println(myList);


}
}
