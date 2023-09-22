import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        LinkedList<Integer> primeList = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();
        
        for (int i = 2; i <= n; i++)
        {
            numList.addLast(new Integer(i));
        }






    }
}
