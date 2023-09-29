import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        Map<String, Integer> map = new TreeMap<>();

        map.put("bannana", 2);
        map.put("apple", 1);
        map.put("carrot", 3);
        map.put("zebra", 5);
        map.put("duck", 4);
        
        for (String s : map.keySet())
        {
            System.out.println(map.get(s));
        }


    }
}
