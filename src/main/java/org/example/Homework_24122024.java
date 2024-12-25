package org.example;

import java.util.Arrays;

public class Homework_24122024 {

    public static void main(String[] args) {
        String string = "I love Java";
        turnString(string);

        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumbers(ints);

        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        int indexOfSecondLargest = findSecondMaxElement(arr);
        System.out.printf("Index %d, value %d.\n", indexOfSecondLargest, arr[indexOfSecondLargest]);

        //String string1 = "Hello world";
        //String string1 = "Hello_world";
        String string1 = "    fly me    to the moon    ";
        System.out.println(lengthOfLastWord(string1));

        //String string2 = "1,234,321";
        //String string2 = "He lived as a devil, eh?";
        //String string2 = "АбЮйААПЫ ,,ыПаай,юБА";
        //String string2 = "A man, a plan, a canal, Panama!";

        //String string2 = "abc";
        //String string2 = "112233";
        //String string2 = "aba";
        String string2 = "112211";

        System.out.println(isPalindrome(string2));
    }

    // Перевернуть строку и вывести на консоль
    // String string = "I love Java";
    public static void turnString(String string) {
        //StringBuilder sb = new StringBuilder(string);
        //System.out.println(sb.reverse());

        char[] charArray = string.toCharArray();
        char temp;

        for (int i = 0; i < charArray.length / 2; i++) {
            temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }

        System.out.println(charArray);
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        //для любого массива
        //int[] result = Arrays.stream(ints).distinct().toArray();
        //System.out.println(Arrays.toString(result));

        //для отсортированного массива
        int j = 0;
        int i = 1;

        while (i < ints.length)
        {
            if (ints[i] == ints[j]) {
                i++;
            }
            else {
                j++;
                ints[j] = ints[i];
                i++;
            }
        }

        int[] result = Arrays.copyOf(ints, j + 1);
        System.out.println(Arrays.toString(result));
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int maxIndex = 0, secondToMaxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                secondToMaxIndex = maxIndex;
                maxIndex = i;
            } else if (arr[i] != arr[maxIndex] && arr[i] > arr[secondToMaxIndex]) {
                secondToMaxIndex = i;
            }
        }

        return secondToMaxIndex;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        String newString = string.trim();
        System.out.println(newString);

        int lastSpaceIndex = newString.lastIndexOf(" ");
        System.out.println(lastSpaceIndex);

        return newString.substring(lastSpaceIndex + 1).length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        //string = string.replaceAll("[^A-Za-z0-9А-Яа-я]","").toLowerCase();
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
