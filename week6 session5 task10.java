import java.util.*;

public class Solution {

    public static int longestPalindrome(String s) {
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int len1 = expand(s, i, i);

            // Even length palindrome
            int len2 = expand(s, i, i + 1);

            maxLength = Math.max(maxLength, Math.max(len1, len2));
        }

        return maxLength;
    }

    public static int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        for (int i = 0; i < n; i++) {

            // Current rotation
            String rotation = s.substring(i) + s.substring(0, i);

            int answer = longestPalindrome(rotation);

            System.out.println(answer);
        }

        sc.close();
    }
}



OUTPUT:


Input (stdin)
13
aaaaabbbbaaaa
Your Output (stdout)
12
12
10
8
8
9
11
13
11
9
8
8
10
Expected Output
12
12
10
8
8
9
11
13
11
9
8
8
10
