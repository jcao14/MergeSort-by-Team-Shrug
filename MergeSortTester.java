/*======================================
  class MergeSortTester
  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>
  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>
  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 
  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    private static int[] merge( int[] a, int[] b ) 
    {
        int[] output = new int[a.length + b.length];
        int counterA = 0;
        int counterB = 0;
        int index = 0;
        
        while ( ((counterA) < (a.length)) && ( (counterB) < (b.length) )){
            if (a[counterA] < b[counterB]){
                output[index] = a[counterA];
                counterA ++;
                index ++;
            }
            
            else{
                output[index] = b[counterB];
                counterB ++;
                index ++;
            }
        }
        
        if (counterA >= a.length){
            for (int i = counterB; i < b.length; i++){
                output [index]= b[i];
                index ++;
            }
        }
        
        if (counterB >= b.length){
            for (int i = counterA; i < a.length; i++){
                output [index]= a[i];
                index ++;
            }
        }
        return output;
    }//end merge()
    
    public static int[] sort( int[] arr ) 
    {
        if (arr.length == 1){
            return arr;
        }
        
        else{
            int size = (int)(arr.length /2);
            int[] a = new int[size];
            int[] b = new int[arr.length - size];
            
            for (int i = 0; i < size; i++){
                a[i] = arr[i];
            }
            
            for (int i = size; i < arr.length; i++){
                b[i - size] = arr[i];
            }
            return  merge(sort(a), sort(b));
        }

    }//end sort()
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {

    }//end main

}//end class
