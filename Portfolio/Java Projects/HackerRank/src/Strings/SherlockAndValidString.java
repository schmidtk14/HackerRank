package Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAndValidString {
    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for(Character c: s.toCharArray()){
            if(charCountMap.containsKey(c)){
                int value = charCountMap.get(c);
                value++;
                charCountMap.put(c, value);
            }
            else{
                charCountMap.put(c, 1);
            }
        }

        Set<Integer> countSet = new HashSet<>(charCountMap.values());
        if(countSet.size()>2){
            return "NO";
        }
        else if(countSet.size()==1){
            return "YES";
        }
        else{
            Integer countOne = (Integer)countSet.toArray()[0];
            Integer countTwo = (Integer)countSet.toArray()[1];
            Integer totalCharOfFreqOne = 0;
            Integer totalCharOfFreqTwo = 0;
            for(Integer i: charCountMap.values()){
                if(i.equals(countOne)){
                    totalCharOfFreqOne++;
                }
                else if(i.equals(countTwo)){
                    totalCharOfFreqTwo++;
                }
            }
            if(((countOne==1)&&(totalCharOfFreqOne==1))||((countTwo==1)&&totalCharOfFreqTwo==1)){
                return "YES";
            }
            else if(Math.abs(countOne - countTwo)>1){
                return "NO";
            }
            if((totalCharOfFreqOne>1)&&(totalCharOfFreqTwo>1)){
                return "NO";
            }
            else{
                return "YES";
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println(result);
        scanner.close();
    }
}
