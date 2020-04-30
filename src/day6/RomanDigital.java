package day6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RomanDigital {

    public int romanToInt(String s) {
        Map<String, Integer> map1 = new HashMap<>(10);
        map1.put("IV", 4);
        map1.put("IX", 9);
        map1.put("XL", 40);
        map1.put("XC", 90);
        map1.put("CD", 400);
        map1.put("CM", 900);
        Map<String, Integer> map2 = new HashMap<>(10);
        map2.put("I", 1);
        map2.put("V", 5);
        map2.put("X", 10);
        map2.put("L", 50);
        map2.put("C", 100);
        map2.put("D", 500);
        map2.put("M", 1000);

        int result = 0;
        Set<Map.Entry<String, Integer>> entries1 = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entries1) {
            if (s.contains(entry.getKey())) {
                s = s.replace(entry.getKey(), "");
                result += entry.getValue();
            }
        }

        Set<Map.Entry<String, Integer>> entries2 = map2.entrySet();
        while (!"".equals(s)) {
            for (Map.Entry<String, Integer> entry : entries2) {
                if (s.contains(entry.getKey())) {
                    s = s.replaceFirst(entry.getKey(), "");
                    result += entry.getValue();
                }
            }
        }

        return result;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>(10);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        char[] roman = s.toCharArray();
        for (int i = 1; i < roman.length; i++) {
            if (map.get(roman[i-1]) >= map.get(roman[i])) {
                result = result + map.get(roman[i-1]);
            } else{
                result = result - map.get(roman[i-1]);
            }
        }
        result += map.get(roman[roman.length-1]);

        return result;
    }

    public int romanToInt3(String s) {
        int result = 0;
        char[] roman = s.toCharArray();
        for (int i = 1; i < roman.length; i++) {
            if (getInt(roman[i-1]) >= getInt(roman[i])) {
                result = result + getInt(roman[i-1]);
            } else{
                result = result - getInt(roman[i-1]);
            }
        }
        result += getInt(roman[roman.length-1]);
        return result;
    }

    public int romanToInt4(String s) {
        int result = 0;
        char[] roman = s.toCharArray();
        int num, lastNum = 2147483647;
        for (int i = 0; i < roman.length; i++) {
            num = getInt(roman[i]);
            result += num;
            if (num > lastNum) {
                result -= lastNum * 2;
            }
            lastNum = num;
        }
        return result;
    }

    private int getInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public void test() {
        System.out.println(romanToInt4("MCMXCIV"));
    }
}
