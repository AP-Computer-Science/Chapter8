
public class PalindromeTester {
    public static void main(String[] args) {
        System.out.println(isPalindrome("bob"));
        System.out.println(isPalindrome("cat"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("eye"));
        System.out.println(isPalindrome("dad"));
        System.out.println(isPalindrome("sam"));
    }
    private static boolean isPalindrome(String word) {
        if(word.length() <= 1) return true;
        if(word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalindrome(word.substring(1, word.length() - 1));
        }
        else return false;
    }
}
