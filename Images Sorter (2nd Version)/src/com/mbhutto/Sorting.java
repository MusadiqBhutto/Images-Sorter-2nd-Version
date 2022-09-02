package com.mbhutto;

import java.io.File;

public class Sorting
{
    private String sortBY ;
    private String orderBY;
    private File[] unsorted;
    private File[] sorted;


    public Sorting(String sortBY, String orderBY, File[] file )
    {
        this.sortBY = sortBY;
        this.orderBY = orderBY;
        this.unsorted = file;

        sort();
    }

    // Bubble Sorting
    private void sort()
    {
        if(sortBY.equals(Constants.SORT_BY_NAME))
        {
            for (int i=0; i<unsorted.length; i++)
            {
                for (int j=i+1; j<unsorted.length; j++)
                {
                    if (unsorted[i].getName().compareToIgnoreCase(unsorted[j].getName()) > 0)
                    {
                        File temp = unsorted[i];
                        unsorted[i] = unsorted[j];
                        unsorted[j] = temp;
                    }


                }
                this.sorted = unsorted;
            }

            if(orderBY == Constants.ORDER_BY_DESCENDING)
            {
                int j = unsorted.length;
                File[] reversed = new File[unsorted.length];

                for (int i = 0; i < unsorted.length; i++)
                {
                    reversed[j - 1] = unsorted[i];
                    j = j - 1;
                }

                this.sorted = reversed;
            }
        }

        else if(sortBY.equals(Constants.SORT_BY_SIZE))
        {
            for (int i=1; i<unsorted.length; i++)
            {
                int j = i;
                File temp = unsorted[i];

                while ((j > 0) && (unsorted[j-1].length() > temp.length()))
                {
                    unsorted[j] = unsorted[j-1];
                    j--;
                }
                unsorted[j] = temp;
            }

            this.sorted = unsorted;

            if(orderBY == Constants.ORDER_BY_DESCENDING)
            {
                for(int i=0; i<unsorted.length/2; i++)
                {
                    File temp = unsorted[i];
                    unsorted[i] = unsorted[unsorted.length -i -1];
                    unsorted[unsorted.length -i -1] = temp;

                }

                this.sorted = unsorted;

            }

        }
   }

   public File[] getSorted()
   {
       return this.sorted;
   }



}