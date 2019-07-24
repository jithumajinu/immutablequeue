package com.immutablequeue;

public interface Queue<E> {
    public Queue<E> enQueue(E e);
    public Queue<E> deQueue();
    public E head();
    public boolean isEmpty();
}
