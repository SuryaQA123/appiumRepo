package Logical_Programmes;

import org.testng.annotations.Test;

public class Test_Demo {
    @Test
    public void string_Revesre() {
//        rev("Devendra");
      String s3=  d1("My name is Devendra");
      System.out.println(s3);
    }

    public void revesreWord(String str) {
        String[] split = str.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(split[i]);

        }


    }


    public static void rev(String str) {
        char[] chr = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(chr[i]);
        }
    }

    public String d1(String input) {
        String[] words = input.split(" ");
        String reversedString = " ";

        for (int i = words.length - 1; i >= 2; i--) {
            reversedString += words[i] + " ";
        }
        reversedString+= words[0]+" ";

        reversedString += words[1]; // Append the first word without a trailing space

        return reversedString;
    }
}



