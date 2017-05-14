package com.smartsparrow.codingchallenge.resolution

import com.smartsparrow.codingchallenge.exception.EmptyStringException

/**
 * Anagram lookup in one string according to a provided pattern
 */
class AnagramLookup {

    /**
     * The function to search all the anagram from a string according to a pattern
     * @return A list of String (Anagrams) from a string
     * @throws EmptyStringException if the input is not recognised
     */
    public static void searchAnagramSubstring(){
        BufferedReader stdin = System.in.newReader()
        System.out.println("Please enter you string you want to find anagram in: ")
        String text = stdin.readLine().toLowerCase()

        System.out.println("Please enter pattern you want to look for in the string: ")
        String pattern = stdin.readLine().toLowerCase()

        if (text == "" || text == null || pattern == "" || pattern == null) {
            throw new EmptyStringException("Entered string is not valid!")
        }

        int count = 0;
        int n = text.length()
        int m = pattern.length()
        int i = 0

        if(n < m | m == 0 | m == 0){
            throw new EmptyStringException("Both strings cannot be null and text needs to" +
                    "be of equal or greater size than pattern")
        }

        String[] textToLookIn = []
        String[] patternToLookFor = []

        for(i = 0; i < m; i++){
            textToLookIn += text.charAt(i)
            patternToLookFor += pattern.charAt(i)
        }

        while(true) {
            if(findAnagram(textToLookIn, patternToLookFor)){
                count++;
            }

            if (text.charAt(i) && text.charAt(i-m)) {
                textToLookIn += text.charAt(i)
                textToLookIn[i-m] = ""
            }

            if (++i >= n) {
                break
            }
        }

        println(count)
    }

    private static boolean findAnagram(String[] text, String[] pattern){
        int check = 0
        if (pattern.length > text.length) {
            return false
        } else {
            for(int i = 0; i < pattern.length; i++){
                if (text.contains(pattern[i])) {
                    check ++
                }
            }
        }
        if (check == pattern.length) {return true} else {return false}
    }
}
