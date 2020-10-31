package Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagrams {
    static int makeAnagram(String a, String b) {
        int deleted = 0;
        HashMap<String, Integer> aMap = new HashMap();
        HashMap<String, Integer> bMap = new HashMap();

        for(int i=0; i<a.length(); i++){
            String aKey = String.valueOf(a.charAt(i));
            if(!aMap.containsKey(aKey)){
                aMap.put(String.valueOf(aKey), 1);
            }
            else{
                int value = aMap.get(String.valueOf(aKey));
                value += 1;
                aMap.put(aKey, value);
            }
        }

        for(int i=0; i<b.length(); i++){
            String bKey = String.valueOf(b.charAt(i));
            if(!bMap.containsKey(bKey)){
                bMap.put(String.valueOf(bKey), 1);
            }
            else{
                int value = bMap.get(String.valueOf(bKey));
                value += 1;
                bMap.put(bKey, value);
            }
        }
        Set<String> keySet = aMap.keySet();
        for(String key: keySet){
            if(bMap.containsKey(key)){
                int aValue = aMap.get(key);
                int bValue = bMap.get(key);
                deleted += Math.abs(aValue-bValue);
                bMap.remove(key);
            }
            else{
                deleted+=aMap.get(key);
            }
        }

        keySet = bMap.keySet();
        if(!bMap.isEmpty()){
            for(String key: keySet){
                deleted+=bMap.get(key);
            }
        }
        return deleted;
    }

}
