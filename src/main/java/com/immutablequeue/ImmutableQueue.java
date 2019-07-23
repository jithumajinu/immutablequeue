package com.immutablequeue;

import java.util.NoSuchElementException;

public final class ImmutableQueue<E> implements Queue<E> {

    private StackContainer<E> orderStack;

    private StackContainer<E> reverseStack;

    /**
     * (Parameterised constructor
     * Queue implementations generally do not allow insertion of null elements
     * return New instance)
     *
     * @param (StackContainer orderStack) (Generic Type)
     * @param (StackContainer reverseStack) (Generic Type)
     */
    private ImmutableQueue(StackContainer<E> orderStack, StackContainer<E> reverseStack) {
        this.orderStack = orderStack;
        this.reverseStack = reverseStack;
    }


    /**
     * (Default constructor)
     *
     */
    public ImmutableQueue() {
        this.orderStack = StackContainer.emptyStack();
        this.reverseStack = StackContainer.emptyStack();
    }


    /**
     * (insert value in to queue
     * Queue implementations generally do not allow insertion of null elements
     * return New instance)
     *
     * @param ( e) (Generic Type)
     * @return (ImmutableQueue)
     */
    public ImmutableQueue<E> enQueue(E e) {
        if (null == e)
            throw new IllegalArgumentException();
        return new ImmutableQueue<E>(this.orderStack.push(e), this.reverseStack);
    }



    /**
     * (If it is empty , throw exception
     * return New instance)
     *
     * @return (ImmutableQueue)
     */
    public ImmutableQueue<E> deQueue() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        if (!this.reverseStack.isEmpty()) {
            return new ImmutableQueue<E>(this.orderStack, this.reverseStack.tail);
        } else {
            return new ImmutableQueue<E>(StackContainer.emptyStack(),this.orderStack.getReverseStack().tail);
        }
    }


    /**
     * (If it is empty , throw exception
     * return New instance)
     *
     * @return (ImmutableQueue)
     */
    private void manageQueue() {
        this.reverseStack = this.orderStack.getReverseStack();
        this.orderStack = StackContainer.emptyStack();
    }


    /**
     * (If it is empty , throw exception
     * return New instance)
     *
     * @return (E) generic
     */
    public final E head() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        if (this.reverseStack.isEmpty())
            manageQueue();
        return this.reverseStack.head;
    }


    /**
     * (tatus of queue)
     * @return (boolean) s
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * (claculate the size of queue)
     * @return (int)
     */
    private int size() {
        return this.orderStack.size + this.reverseStack.size;
    }

    /**
     * ( Private and static class
     * stack data structure )
     *
     */
    private static class StackContainer<E> {

        private E head;   //top of original stack
        private StackContainer<E> tail; //top of reversed stack
        private int size;

        /**
         * (Default constructor)
         */
        private StackContainer() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        /**
         * ( Parameterized constructor)
         * @param (E obj) (Gener type)
         * @param (StackContainer tail)
         */
        private StackContainer(E obj, StackContainer<E> tail) {
            this.head = obj;
            this.tail = tail;
            this.size = tail.size + 1;
        }


        /**
         * @return (new instance (Empty))
         */
        public static StackContainer emptyStack() {
            return new StackContainer();
        }

        /**
         * ( Manage stack)
         * @return (StackContainer stack)
         */
        public StackContainer<E> getReverseStack() {
            StackContainer<E> stack = new StackContainer<E>();
            StackContainer<E> tail = this;
            while (!tail.isEmpty()) {
                stack = stack.push(tail.head);
                tail = tail.tail;
            }
            return stack;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public StackContainer<E> push(E obj) {
            return new StackContainer<E>(obj, this);
        }
    }  // StackContainer END

} // immutableQueue END

