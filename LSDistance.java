public class LSDistance
{
    public static void main(String[] args)
    {
        String wordOne = args[0];
        String wordTwo = args[1];

        System.out.println(LSCalcMemo(wordOne, wordTwo));
    }

    public static int LSCalcHelp(String wordOne, String wordTwo)
    {
        return LSCalc(wordOne, wordTwo, wordOne.length()-1, wordTwo.length()-1);
    }

    public static int LSCalc(String wordOne, String wordTwo, int i, int j)
    {
        int cost = 0;

        if(i < 0)
        {return j+1;}

        if(j < 0)
        {return i+1;}

        if(wordOne.charAt(i) != wordTwo.charAt(j))
        {
            cost = 1;
        }

        return Math.min(
            LSCalc(wordOne, wordTwo, i-1, j) + 1,
            Math.min(
                LSCalc(wordOne, wordTwo, i, j-1) + 1,
                LSCalc(wordOne, wordTwo, i-1, j-1) + cost
            )
        );
    }

    public static int LSCalcMemo(String wordOne, String wordTwo)
    {
        int i = wordOne.length() + 1;
        int j = wordTwo.length() + 1;
        int[][] matrix = new int[i][j];

        //Base Cases
        for(int k = 0 ; k < i ; k++)
        {
            matrix[k][0] = k;
        }
        for(int l = 0 ; l < j ; l++)
        {
            matrix[0][l] = l;
        }

        //Fill in matrix
        for(int k = 1 ; k < i ; k++)
        {
            for(int l = 1 ; l < j ; l++)
            {
                int min = Math.min(
                    matrix[k-1][l],
                    Math.min(
                        matrix[k][l-1],
                        matrix[k-1][l-1]
                    )
                );
                if(wordOne.charAt(k-1) != wordTwo.charAt(l-1))
                    matrix[k][l] = min + 1;
                else
                    matrix[k][l] = min;
            }
        }

        return matrix[i-1][j-1];
    }
}