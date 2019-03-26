class HighArray
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //-----------------------------------------------------------
    public boolean find(long searchKey)
    {                              // find specified value
        int j;
        for(j=0; j<nElems; j++)            // for each element,
            if(a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if(j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()
    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)        // look for it
            if( value == a[j] )
                break;
        if(j==nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k=j; k<nElems; k++) // move higher ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    public int getMax(){
        if(a.length == 0){
            return -1;
        } else {
            int count = 0;
            for (int j = 0; j < nElems; j++) {
                for (int i = 0; i < nElems; i++) {
                    if (a[j] >= a[i]) {
                        count++;
                    }
                    if (count == nElems) {
                        return (int) a[j];
                    }
                }
                count = 0;
            }
            return -1;
        }
    }

    public int getnElems(){
        return nElems;
    }


    public int removeMax(){
        int max = getMax();
        if(max!=-1)
            delete(max);
        return max;
    }

    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------
}  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        HighArray arr;
        HighArray arr2;// reference to array
        arr = new HighArray(maxSize); // create the array
        arr2 = new HighArray(maxSize);

        arr.insert(3);               // insert 10 items
        arr.insert(2);
        arr.insert(5);
        arr.insert(0);
        arr.insert(1);
        int elements = arr.getnElems();
        for(int i = 0; i<elements;i++){
            arr2.insert(arr.removeMax());
        }

        arr2.getMax();

        arr.display();                // display items

        //System.out.println("Max Value is: "+ arr.getMax());
        //System.out.println("Removing max value:"+ arr.removeMax());
        System.out.println("Second array: ");
        arr2.display();

        int searchKey = 35;           // search for item
        if( arr.find(searchKey) )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        //arr.delete(00);               // delete 3 items
        //arr.delete(55);
        //arr.delete(99);

        arr.display();                // display items again
    }  // end main()
}  // end class HighArrayApp
