package WarmUp;

import java.io.*;
import java.util.*;


public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long aCount = 0;
        long numWhole = n/s.length();
        int remainder = (int) (n%s.length());
        //a count for one whole string
        for(char c: s.toCharArray()){
            if(c=='a'){
                aCount++;
            }
        }
        //multiply by numWhole to determine a count for all whole strings
        aCount*=numWhole;

        if(remainder==0){
            return aCount;
        }

        //add a count for the remainder of the string
        else{
            String subString = s.substring(0, remainder);
            for(char c: subString.toCharArray()){
                if(c=='a'){
                    aCount++;
                }
            }
        }
        return aCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long result = repeatedString(s, n);
        System.out.println(String.valueOf(result));
        scanner.close();
    }

}
