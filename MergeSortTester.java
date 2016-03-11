// Team Shrug -- Sadia Azmine, James Cao, Jessica Yang
// APCS2 pd9
// HW11 -- Wrapping It Up
// 2016-03-10

/*======================================
  class MergeSortTester
  ALGORITHM:
  The MergeSort requires n splits and n merge to properly order a list of numbers.
  Split an array of numbers until you reach all single element arrays. Merge and sort until you 
  get a single sorted array the same size as the one you started with.
  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlogn)
  Mean execution times for dataset of size n:
  Batch size: 1000
  n=1       time: 0.001 ms
  n=10      time: 0.002 ms
  n=100     time: 0.028 ms
  ...
  n=1000  time: 0.253 ms
  ANALYSIS:
  As the arrays increased in size, the runtimes got larger. 
  Although this may be slightly affected by our testing apparatus calling two functions in the for loop, the trend
  is the same. Every 10 fold increase in size seems to lead to a logarithmically increasing average time. 
  ======================================*/

public class MergeSortTester 
{
   /*===================================================
   Helper Functions to populate, shuffle, and visualize an int array
   =====================================================*/
    //populates array
    public static int [] populate( int size, int lo, int hi ) {
    	int[] retAL = new int[size];
    	while( size > 0 ) {
    	    //     offset + rand int on interval [lo,hi]
    	    retAL[size-1] = ( lo + (int)( (hi-lo+1) * Math.random() ) );
    	    size--;
    	}
    	return retAL;
    }
    
    //shuffles an array
    public static void shuffle( int [] a ) {
	     int randomIndex;
       for( int i = a.length-1; i > -1; i-- ) {
	          //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
      	    //swap the values at position i and randomIndex
      	    int tmp = a[randomIndex];
      	    a[randomIndex] = a[i];
      	    a[i] = tmp;
        }
    }//end sort()
    
    //prints contents of int[]
    public static String stringify(int[] arr) {
    	String retStr = "";
    	for (int x = 0; x < arr.length; x++) {
    	    retStr += arr[x] + ",";
    	}
    	return retStr;
        }

    
    /******************************
     * execution time analysis 
     We created arrays of length 1,10,100 and 1000 and populated them with random numbers. 
     Then we tested the time of the MergeSort by sorting these arrays and shuffling them 
     afterwards for 1000 runs. After 1000 runs, we averaged the times.
     ******************************/
    public static void main( String[] args ) 
    {
    	//testing populate and shuffle
         
    	int[] a = populate(1,1,100);
    	/*System.out.println(stringify(a));
    	  shuffle(a);
    	  System.out.println(stringify(a));*/
    
    	int[] b = populate(10,1,100);
    	/*System.out.println(stringify(b));
    	  shuffle(b);
    	  System.out.println(stringify(b));*/
    
    	int[] c = populate(100,1,100);
    	/*System.out.println(stringify(c));
    	  shuffle(c);
    	  System.out.println(stringify(c));*/
    
    	int[] d = populate(1000,1,100);
    	/*System.out.println(stringify(d));
    	  shuffle(d);
    	  System.out.println(stringify(d));*/
    
    	// testing mergeSort
    	
    	double totalTime = 0;
    	System.out.println( "\nn = 1" );
    	for ( int x = 0; x < 1000; x++ ) {
    	    double time = System.currentTimeMillis();
    	    //System.out.println(stringify(MergeSort.sort(a)));
    	    MergeSort.sort(a);
    	    totalTime += ( System.currentTimeMillis() - time );
    	    shuffle(a); 
    	}
    	System.out.println( "Total: " + totalTime );
    	System.out.println( "Average: " + totalTime / 1000 );
    
    	totalTime = 0;
    	System.out.println( "\nn = 10" );
    	for ( int x = 0; x < 1000; x++ ) {
    	    double time = System.currentTimeMillis();
    	    //System.out.println(stringify(MergeSort.sort(b)));
    	    MergeSort.sort(b);
    	    totalTime += ( System.currentTimeMillis() - time );
    	    shuffle (b);
    	}
    	System.out.println( "Total: " + totalTime );
    	System.out.println( "Average: " + totalTime / 1000 );
    
    	totalTime = 0;
    	System.out.println( "\nn = 100" );
    	for ( int x = 0; x < 1000; x++ ) {
    	    double time = System.currentTimeMillis();
    	    //System.out.println(stringify(MergeSort.sort(c)));
    	    MergeSort.sort(c);
    	    totalTime += ( System.currentTimeMillis() - time );
    	    shuffle (c);
    	}
    	System.out.println( "Total: " + totalTime );
    	System.out.println( "Average: " + totalTime / 1000 );
    
    	totalTime = 0;
    	System.out.println( "\nn = 1000" );
    	for ( int x = 0; x < 1000; x++ ) {
    	    double time = System.currentTimeMillis();
    	    //System.out.println(stringify(MergeSort.sort(d)));
    	    MergeSort.sort(d);
    	    totalTime += ( System.currentTimeMillis() - time );
    	    shuffle(d);
    	}
    	System.out.println( "Total: " + totalTime );
    	System.out.println( "Average: " + totalTime / 1000 );

    }//end main

}//end class
y
