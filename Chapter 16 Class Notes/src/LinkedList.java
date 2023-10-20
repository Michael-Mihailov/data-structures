import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    private Node first;
    private Node last;
    private int size;

    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }
    
    // return the size of the list
    public int size()
    {
        return size;
    }

    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        return first.getData();
    }
    public Object getLast()
    {
        return last.getData();
    }




    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        if (first != null) size--;

        Object o = first.getData();
        first = first.getNext();
        

        return o;
    }
    public Object removeLast()
    {
        if (last != null) size--;

        Object o = last.getData();
        last = last.getPrevious();
        

        return o;
    }





    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object o)
    {
        if (first == null)
        {
            first = new Node(o);
            return;
        }

        size++;

        Node n = new Node(o);
        n.setNext(first);
        first.setPrevious(n);

        first = n;
    }
    public void addLast(Object o)
    {
        if (size == 0)
        {
            addFirst(o);
            return;
        }

        size++;

        Node n = new Node(o);
        n.setPrevious(last);
        last.setNext(n);

        last = n;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator linkedListIterator()
    {
        return new LinkedListIterator(first);
    }





    //Class Node
    static class Node
    {
        private Node next;
        private Node previous;
        private Object data;

        public Node(Object d)
        {
            setData(d);
            next = null;
            previous = null;
        }

        public void setNext(Node n)
        {
            next = n;
        }

        public void setPrevious(Node n)
        {
            previous = n;
        }

        public void setData(Object d)
        {
            data = d;
        }

        public Node getNext()
        {
            return next;
        }

        public Node getPrevious()
        {
            return previous;
        }

        public Object getData()
        {
            return data;
        }
    }

    class LinkedListIterator implements ListIterator
    {
      //private data
        private int index;
        // will also need to access size
        private Node currentNode;
        private boolean canModify;


        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(Node start)
        {
            index = 0;
            canModify = false;
            currentNode = start;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next() // add error
        {
            index++;
            canModify = true;

            currentNode = currentNode.getNext();
            
            return currentNode.getData();
        }
        public Object previous() // add error
        {
            index--;
            canModify = true;

            currentNode = currentNode.getPrevious();

            return currentNode.getData();
        }





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {
            return currentNode.getNext() != null;
        }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object o)
        {
            if (index == 0)
            {
                addFirst(o);
                currentNode = first;
            }
            else if (index == size)
            {
                addLast(o);
            }
            else
            {
                Node n = new Node(o);
                n.setPrevious(currentNode.getPrevious());
                n.setNext(currentNode);
                currentNode.setPrevious(n);
                
                currentNode = n;
            }

            size++;
            canModify = false;
        }






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove()
        {
            if (!canModify)
            {
                // error
                return;
            }

            if (index == 0)
            {
                removeFirst();
                currentNode = first;
            }
            else if (index == size)
            {
                removeLast();
                currentNode = last;
            }
            else
            {
                currentNode.getPrevious().setNext(currentNode.getNext());
                currentNode.getNext().setPrevious(currentNode.getPrevious());

                currentNode = currentNode.getNext();
            }

            size--;
            canModify = true;
        }







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object o)
        {
            if (canModify)
                currentNode.setData(o);
            else;
                // error
        }




    }//LinkedListIterator
}//LinkedList
