package Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
        int deleted = 0;

        for(int i=0; i<s.length()-1; i++){
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i+1);
            if(currentChar == nextChar)
                deleted += 1;
        }

        return deleted;
    }


}
