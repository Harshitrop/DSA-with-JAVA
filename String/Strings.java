import java.util.*;

public class Strings {
    public static boolean ispalindrome(String str){
        int n = str.length();
        for(int i =0; i<n/2; i++ ){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    public static float displacement(String path){
        int n = path.length();
        int x = 0;
        int y = 0;
        for(int i =0; i<n; i++){
            char dir = path.charAt(i);
            //south
            if(dir == 'S'){
                y--;
            }
            //north
            else if(dir == 'N'){
                y++;
            }
            //east
            else if(dir == 'E'){
                x++;
            }
            else{
                x--;
            }
        }
        int x2 = x*x;
        int y2 = y*y;
        return (float)Math.sqrt(x2+y2);
    }

    public static String uppercase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i < str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    // String variable
    public static String compression(String str){
        String newstr = "";
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if(count > 1){
                newstr += count.toString();
            }
        }
        return newstr;
    }

    // String Builder
    public static String compression2(String str){
        StringBuilder newstr = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if(count > 1){
                newstr.append(count);
            }
        }
        return newstr.toString();
    }
    // practice question
    //Q2 Count how many times lowercase vowels occurred in a String entered by the user
    public static int countLowercaseVowels(String str){
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }
    // Q3 2Strings areanagrams of each other
    public static void areAnagrams(String str1, String str2){
        
        //Convert Strings to lowercase. Why? so that we don't have to check separately for lower & uppercase
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        // First check - if the lengths are the same
        if(str1.length() == str2.length()){

            // convert strings into char array 
            char str1charArray[] = str1.toCharArray();
            char str2charArray[] = str2.toCharArray();

            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            // if the sorted char arrays are same or identical then the strings areanagram
            boolean result = Arrays.equals(str1charArray,str2charArray);
            if(result){
                System.out.println(str1 + " and " + str2 + " are Anagrams of Eachother.");
            }
            else{System.out.println(str1 + " and " + str2 + " are not Anagrams of Eachother.");
            }
        }
        else{
            //case when lengths are not equal
            System.out.println(str1 + " and " + str2 + " are not Anagrams of Eachother.");
        }   
    }

    public static void main(String[] args){
        String str1 = "race";
        String str2 = "care";
        areAnagrams(str1, str2);
    }


}
