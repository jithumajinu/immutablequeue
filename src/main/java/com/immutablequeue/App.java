package com.immutablequeue;
/**
 * (Program to create Immutable queue
 *  use 2 stacks to make it
 * )
 *
 * @author (Jithu p m)
 */
public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Immutable queue!");

        ImmutableQueue<Integer> imq1 = new ImmutableQueue<Integer>();
        ImmutableQueue<String>  imq2 = new ImmutableQueue<String>();

        imq1 = imq1.enQueue(5);
        imq1 = imq1.enQueue(4);
        imq2 = imq2.enQueue("A");
        imq2 = imq2.enQueue("B");
        System.out.println("imq1 head ="+imq1.head());
        imq1 = imq1.deQueue();
        System.out.println("imq1 head ="+imq1.head());

        System.out.println("imq2 head ="+imq2.head());
        imq2 = imq2.deQueue();
        System.out.println("imq2 head ="+imq2.head());
        System.out.println("imq2 isEmpty ="+imq2.isEmpty());
        imq2 = imq2.deQueue();
        System.out.println("imq2 isEmpty ="+imq2.isEmpty());

        /*
        ===OUTPUT===

        imq1 head =5
        imq1 head =4
        imq2 head =A
        imq2 head =B
        imq2 isEmpty =false
        imq2 isEmpty =true
         */

    }
}
