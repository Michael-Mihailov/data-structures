import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        PriorityQueue<Object> q = new PriorityQueue();

        q.add(2);
        q.add(5);
        q.add(-7);
        q.add(3);
        q.add("Hello world");

        while (q.size() > 0)
        {
            System.out.println(q.remove());
        }
    }
}
