package Logical_Programmes;

public class Odemo1 {
    public static void main(String[] args) {
        String var = " My name is Devendra";
        boolean containsVowel = containsVowel("devendra Goud");

        System.out.println("Input String: " + "Devendra goud");
        System.out.println("Contains Vowel: " + containsVowel);
        String[] str = var.split(" ");

        String reverse = " ";
        for (int i = str.length - 1; i > 2; i--) {
            System.out.println(i);
            reverse += str[i] + " ";


        }
        reverse += str[1] + " ";
        reverse += str[2] + " ";
        System.out.println(reverse);
    }
    private static boolean containsVowel(String input) {
        // Convert the string to lowercase to make the comparison case-insensitive
        String lowerCaseInput = input.toLowerCase();

        // Check if the lowercase string contains any vowel
        return lowerCaseInput.matches(".*[x].*");
    }
}
