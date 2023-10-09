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
            String s = sentence.substring(0, sentence.indexOf("."));

            sentence = sentence.substring(sentence.indexOf(".") + 1);

            Scanner sentenceScanner = new Scanner(s);

            Stack<String> sentanceStack = new Stack<>();
            String sen = "";

            while (sentenceScanner.hasNext())
            {
                sentanceStack.push(sentenceScanner.next());
            }
            
            boolean first = true;
            while (sentanceStack.size() > 0)
            {
                String word = sentanceStack.pop();

                if (first)
                {
                    first = false;
                    word = (word.charAt(0) + "").toUpperCase() + word.substring(1);
                }
                else
                {
                    word = " " + word;
                }
                if (sentanceStack.size() == 0)
                {
                    word = word.toLowerCase();
                }


                sen = sen + word;
            }
            

            sen += ".";

            answer += sen;
            if (sentence.length() > 0)
            {
                answer += " ";
            }
        }



        



        return answer;


    }
}
