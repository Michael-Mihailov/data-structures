import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        /*
        Stack<String> daStack = new Stack<String>();

        daStack.add("potato");
        System.out.println(daStack.pop());

        daStack.pop();
        */
        
        /*
        Stack<Integer> nums = new Stack<Integer>();
        int num = 0;
        while (true)
        {
            num++;
            nums.push(num);
            if (nums.peek() % 1000000 == 0) System.out.println(nums.peek());
        }
        */

        /*
        Stack test = new Stack<>();
        
        int num = 0;
        int prevCap = -1;
        while (true)
        {
            num++;
            test.push(num);
            if (test.capacity() != prevCap) 
            {
                System.out.println(num + " :: " + test.capacity());
                prevCap = test.capacity();
            }
        }
        */
    }
}
