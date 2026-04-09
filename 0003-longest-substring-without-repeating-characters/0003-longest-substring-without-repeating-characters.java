import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Map to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 'left' represents the start of the current sliding window
        for (int right = 0, left = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the map, move the left pointer
            // to the right of the previous occurrence (only if it's within the current window)
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }
            
            // Update the last seen index of the character
            map.put(currentChar, right);
            
            // Calculate the window size and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
