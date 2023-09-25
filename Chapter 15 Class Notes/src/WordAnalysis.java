import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        Set<String> dictionaryWords = readWords("Chapter 15 Class Notes/src/words");
        Set<String> novelWords = readWords("Chapter 15 Class Notes/src/war-and-peace.txt");

        // print all words in novel, but not dictionary

        for (String w: novelWords)
        {
            if (!dictionaryWords.contains(w))
            {
                System.out.println(w);
            }
        }

        // print number of unique words in the novel
        System.out.println(novelWords.size());

        // print number of unique words with >3 letters
        Iterator<String> iter = novelWords.iterator();
        while (iter.hasNext())
        {
            if(iter.next().length > 3)
            {
                iter.remove();
            }
        }
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        Set<String> words = new HashSet<>();

        //System.out.println(System.getProperty("user.dir"));

        Scanner in = new Scanner(new File(filename), "UTF-8");
        in.useDelimiter("[^a-zA-z]+");

        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }

        return words;
    }
}
