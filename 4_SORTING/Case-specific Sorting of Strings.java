import java.util.*;

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        List<Character> upperCase = new ArrayList<>();
        List<Character> lowerCase = new ArrayList<>();
        
        for(char ch : str.toCharArray()){
            if(Character.isUpperCase(ch)){
                upperCase.add(ch);
            } else {
                lowerCase.add(ch);
            }
        }
        
        Collections.sort(upperCase);
        Collections.sort(lowerCase);
        
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isUpperCase(ch)){
                sb.append(upperCase.get(i++));
            } else {
                sb.append(lowerCase.get(j++));
            }
        }
        
        return sb.toString();
    }
}