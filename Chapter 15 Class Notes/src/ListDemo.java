import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> staff = new LinkedList();

        staff.addLast("Clint");
        staff.addLast("Thor");
        staff.addLast("Michael");
        staff.addLast("Loki is cool");

        ListIterator<String> iter = staff.listIterator();
        iter.next();

        String name = iter.next();
        System.out.println(name);

        iter.add("joe");
        iter.add("bruce");

        iter.next(); iter.remove();

        iter.previous(); iter.set("Scott");

        for (String n : staff)
        {
            System.out.println(n);
        }

        

        iter = staff.listIterator(); // reset the iterator


        

    }
}
