import java.util.NoSuchElementException;

/**
    An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
    private Object[] elements;
    //private data
    private int head;
    private int tail;
    private int currentSize;

    private final int INITIAL_SIZE = 5;

    /**
        Constructs an empty queue.
    */
    public CircularArrayQueue()
    {
        elements = new Object[INITIAL_SIZE];
        
        currentSize = 0;
        head = 0;
        tail = 0;
    }






    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty()
    {
        return currentSize == 0;
    }




    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object o)
    {
        elements[tail] = o;
        tail++;
        tail %= elements.length;

        currentSize++;
    }





    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove()
    {
        if (empty()) throw new NoSuchElementException();

        Object answer = elements[head];
        elements[head] = null;

        head++;
        head %= elements.length;
        
        currentSize--;

        return answer;
    }





    /**
        Grows the element array if the current size equals the capacity.
    */
    private void growIfNecessary()
    {
        
        if(this.currentSize == this.elements.length)
        {
            Object[] newElements = new Object[2 * this.elements.length];
            for(int i = 0; i < this.elements.length; i++)
            {
                newElements[i] = this.elements[(head + i) % this.elements.length];
            }
            this.elements = newElements;
            this.head = 0;
            this.tail = this.currentSize;
        }
        
    }




}//CircularArrayQueue
