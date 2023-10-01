import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        //String filename = "Chapter 15 Activities/FirstLetterMap/FirstLetterMap1/src/test1.txt";
        String filename = "test1.txt";
        
        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            TreeMap<Character, TreeSet<String>> map = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);
                
                // Update the map here
                // Use the Java 8 merge method
                if (map.get(c) == null) map.put(c, new TreeSet<String>());
                TreeSet<String> wordSet = new TreeSet(); wordSet.add(word);
                map.merge(c, wordSet, (v1, v2) -> {
                    v1.add(v2.first());
                    return v1;
                    });
            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            System.out.println();
            for (char n : map.keySet())
            {
                System.out.println(n + ": " + map.get(n));
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
