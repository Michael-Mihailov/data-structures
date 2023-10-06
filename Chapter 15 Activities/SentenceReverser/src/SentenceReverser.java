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

            while (sentanceStack.size() > 0)
            {
                sen += sentanceStack.pop();
            }
            

            sen += ".";

            answer += sen;
        }



        



        return answer;


    }
}
