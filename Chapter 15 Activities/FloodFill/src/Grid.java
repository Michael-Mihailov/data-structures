import java.util.*;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<int[]> steps = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int color = 1;

        int[] p = new int[2];
        p[0] = row; p[1] = column;

        steps.push(p);

        /*
        int t = row;
        row = column;
        column = t;
        */

        while (steps.size() > 0)
        {
            int[] pos = steps.pop();
            if (pixels[pos[0]][pos[1]] == 0)
            {
                pixels[pos[0]][pos[1]] = color;
                color++;

                if (pos[1] > 0) // N
                {
                    int[] temp = new int[2];
                    
                    temp[0] = pos[0];
                    temp[1] = pos[1] - 1;

                    steps.push(temp);
                } 
                if (pos[0] < 9) // E
                {
                    int[] temp = new int[2];

                    temp[0] = pos[0] + 1;
                    temp[1] = pos[1];

                    steps.push(temp);
                } 
                if (pos[1] < 9) // S
                {
                    int[] temp = new int[2];

                    temp[0] = pos[0];
                    temp[1] = pos[1] + 1;

                    steps.push(temp);
                } 
                if (pos[0] > 0) // W
                {
                    int[] temp = new int[2];

                    temp[0] = pos[0] - 1;
                    temp[1] = pos[1];

                    steps.push(temp);
                } 
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
