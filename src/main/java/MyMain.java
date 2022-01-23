public class MyMain {
    // Examples From Class:

    // This is the example problem that we did in class
    // This uses recursion to count the total number
    // of digits in a positive number
    public static int numDigits(int x) {
        // Base case
        if (x == 0) {
            return 0;
        }
        // Recursive call
        else {
            return 1 + numDigits(x / 10);
        }
    }

    // This is a wrapper method. It just calls the
    // tail recursive version of num digits!
    public static int numDigits2(int x) {
        return numDigitsTR(x, 0);
    }

    // This is a tail recursive version of numDigits
    // This method should never be called directly;
    // rather the wrapper method numDigits2 should be called
    public static int numDigitsTR(int x, int count) {
        // Base case
        if (x == 0) {
            return count;
        }
        // Recursive call
        else {
            return numDigitsTR(x / 10, count + 1);
        }
    }


    // In-class Practice Problems

    // Write a method that uses recursion to calculate the number
    // of "big" digits in a number
    // A big digit is any digit that is at least 5
    // Examples:
    // countBigDigits(1234) => 0
    // countBigDigits(99999) => 5
    // countBigDigits(521931) => 2
    public static int countBigDigits(int x) {
        return countBigDigitsTR(x, 0);
    }

    public static int countBigDigitsTR(int x, int count) {
        if (x == 0) {
            return count;
        }
        else if (x % 10 < 5) {
            return countBigDigitsTR(x / 10, count);
        }
        else {
            count++;
            return countBigDigitsTR(x / 10, count);
        }
    }

    // Write a method that uses recursion to calculate whether
    // the number contains more odd digits than even digits
    // You will almost certainly need to use **tail recursion!**

    // Hint: what additional parameters will you need to add?

    // Hint 2: you might want to keep track of both the number
    // of odd numbers and the number of even numbers

    // Examples:
    // moreOddThanEven(1234) => false because 2 of each
    // moreOddThanEven(99999) => true because 5 odd and 0 even
    // moreOddThanEven(521931) => true because 5 odd and 1 even
    public static boolean moreOddThanEven(int x) {
        return moreOddThanEvenTR(x,0,0);
    }
    public static boolean moreOddThanEvenTR(int x, int odd_count, int even_count){
        int index_num = x % 10;
        if(x == 0){
            return (odd_count > even_count);
        }
        if(index_num % 2 == 0){
            even_count++;
            return moreOddThanEvenTR(x/10, odd_count, even_count);
        }
        else{
            odd_count++;
            return moreOddThanEvenTR(x/10, odd_count, even_count);
        }
    }

    // This might be helpful to get started:
//    public static boolean moreOddThanEvenTR(...) {

    // This method checks if a String is a palindrome
    // (e.g. "racecar", "madam"), recursively
    // Remember that a palindrome is a word that is the same forwards
    // and backwards, so the first letter must match the last letter,
    // the second letter must match the second to last letter, and so on
    // Examples:
    // isPalindrome("racecar") => true
    // isPalindrome("madam") => true
    // isPalindrome("racecars") => false
    public static boolean isPalindrome(String str) {
        if(str.length() < 2){
            return true;
        }
        if(str.charAt(0)  == str.charAt(str.length() - 1)){
            return isPalindrome(str.substring(1, str.length()-1));
        }
        return false;
    }





    // Methods for homework:

    // This method adds up the values of all digits
    // in x, recursively
    // Examples:
    // countBigDigits(1234) => 10
    // countBigDigits(99999) => 45
    // countBigDigits(521931) => 21
    public static int addDigits(int x) {
        if (x / 10 == 0) {
            return x;
        }
        return x % 10 + addDigits(x / 10);

    }

    // Write a method that is given a String containing a single pair
    // of matched parentheses containing some characters. This method
    // should use recursion to "trim" off all the extra characters until
    // only the parentheses and their contents remain
    // You can assume that the String always contains this pair of parens
    // Examples:
    // parenTrim("xyz(abc)123") => "(abc)"
    // parenTrim("x(hello)") => "(hello)"
    // parenTrim("(xy)1") => "(xy)"
    public static String parenTrim(String str) {
        boolean x = (str.charAt(0)=='(');
        boolean y = (str.charAt(str.length()-1)==')');
        if (x && y){
            return str;
        }
        else if (y){
            return parenTrim(str.substring(1));
        }
        else if (x){
            return parenTrim(str.substring(0,str.length()-1));
        }
        else{
            return parenTrim(str.substring(1,str.length()-1));
        }
    }

    // This method returns the orignal string reversed;
    // tail recursion could be helpful, but it not required!
    // Examples:
    // reverse("desserts") => stressed
    // reverse("racecar") => racecar
    public static String reverse(String str) {
        return reverseTR(str,"");
    }
    public static String reverseTR(String str, String new_string){
        if (str.length() < 1){
            return new_string;
        }
        else{
            new_string = new_string + str.charAt(str.length() - 1);
            return reverseTR(str.substring(0, str.length() - 1), new_string);
        }
    }



    public static void main(String[] args) {
        // Optional: Write some code here to test your methods!
    }
}
