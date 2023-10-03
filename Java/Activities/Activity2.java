package Activities;

public class Activity2 {
    int[] arr={10,77,10,54,-11,10};
    int sum=0;
    int sum() {
        for (int i : arr) {
            if (i == 10) {
                sum = sum + 10;
            }

        }
        return sum;
    }
       boolean result(){
            boolean value=true;
            int sum=sum();
           if(sum!=30){
              value=false;
           }
           return value;
        }

   public static void main(String[] args){
       Activity2 obj=new Activity2();
   System.out.println(obj.result());



   }
}
