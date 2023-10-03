package Activities;

public class Activity4 {
    void arraysort(int[] arr){
       int size=arr.length;
       int k;
       for(int i=0;i<size-1;i++){
           for(int j=i+1;j<size;j++){
               if(arr[i]>arr[j]){
                   k=arr[i];
                   arr[i]=arr[j];
                   arr[j]=k;
               }
           }
       }
    }
    void printarray(int[] arr){

       for(int i:arr){
           System.out.print(i +"\t");
       }
    }
    public static void main (String args[]){
        Activity4 obj=new Activity4();

        int[] arr={4,3,2,10,12,1,5,6};

        System.out.println("Array elements before sorting:");
        obj.printarray(arr);
        System.out.println("\nArray elements after sorting");
        obj.arraysort(arr);
        obj.printarray(arr);
    }
}
