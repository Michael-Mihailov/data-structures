import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
        // Complete this method. Use a Stack.
        String answer = "";
        
        while (sentence.length() > 0)
        {
            System.out.println(sentence + " :: " + answer);

            String s = sentence.substring(0, sentence.indexOf("."));

            sentence = sentence.substring(sentence.indexOf(".") + 1);

            Scanner sentenceScanner = new Scanner(s);

            Stack<String> sentanceStack = new Stack<>();
            String sen = "";

            while (sentenceScanner.hasNext())
            {
                sentanceStack.push(sentenceScanner.next() + " ");
            }

            for (int i = sentanceStack.size(); i > 0; i--)
            {
                String word = sentanceStack.pop();

                if (i == sentanceStack.size()) // last
                {
                    word = word.substring(0, word.length() - 1);
                    word = word.toLowerCase();
                }
                else if (i == 1) // first
                {
                    word = (word.charAt(0) + "").toUpperCase() + word.substring(1);
                }

                sen += word;
            }
            

            sen += ".";

            answer += sen;
        }



        



        return answer;


    }
}
