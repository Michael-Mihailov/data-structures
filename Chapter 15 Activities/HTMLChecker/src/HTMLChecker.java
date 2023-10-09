import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample3.html";

        Stack<String> hStack = new Stack<>();

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            while (in.hasNext())
            {
                String s = in.next(); //System.out.println(s);
                if (s.indexOf('/') == -1)
                {
                    hStack.push(s);
                }
                else
                {
                    if (hStack.size() == 0)
                    {
                        System.out.println("Error1!");
                        return;
                    }
                    if (!hStack.pop().equals(s.replace("/", "")))
                    {
                        System.out.println("Error2!");
                        return;
                    }
                }
            }
            if (hStack.size() != 0)
            {
                System.out.println("Error3!");
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
