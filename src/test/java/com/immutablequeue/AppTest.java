package com.immutablequeue;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for ImmutableQueue.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * (Integer based)
     *
     */
    @Test
    public void immutableQueueTest1() {
        ImmutableQueue<Integer> imq1 = new ImmutableQueue<Integer>();
        imq1 = imq1.enQueue(5);
        imq1 = imq1.enQueue(4);
        assertEquals("5", imq1.head().toString());
        imq1 = imq1.deQueue();
        assertEquals("4", imq1.head().toString());
        assertEquals(false, imq1.isEmpty());
        imq1 = imq1.deQueue();
        assertEquals(true, imq1.isEmpty());

    }

    /**
     * (String based)
     *
     */
    @Test
    public void immutableQueueTest2() {
        ImmutableQueue<String> imq1 = new ImmutableQueue<String>();
        imq1 = imq1.enQueue("A");
        imq1 = imq1.enQueue("B");
        imq1 = imq1.enQueue("C");
        assertEquals("A", imq1.head());
        imq1 = imq1.deQueue();
        assertEquals("B", imq1.head());
    }

    /**
     * (NoSuchElementException)
     *
     */
    @Test (expected = java.util.NoSuchElementException.class)
    public void immutableQueueTest3() {
        ImmutableQueue<String> imq1 = new ImmutableQueue<String>();
        imq1 = imq1.enQueue("A");
        imq1 = imq1.deQueue();  // remove element
        imq1 = imq1.deQueue(); // queue is empty so throw NoSuchElementException
    }


}
