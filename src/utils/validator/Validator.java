package utils.validator;

public class Validator {

    static String wordRegex = "^[A-Za-z]+$";
//    static String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    static String emailRegex = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

    static String isbnRegex = "^\\d{10}|\\d{13}$";

    public static boolean isValidEmail(String email) {
        return email.matches(emailRegex);
    }

    public static boolean isValidISBN(String isbn) {
        return isbn.matches(isbnRegex);
    }

    public static boolean isValidPositiveInt(int quantity) {
        return quantity >= 0;
    }


    public static boolean isWordOnlyAlphabetic(String word) {
        return word.matches(wordRegex);
    }

    public static boolean isValidString_min3_max20(String word) {
        if(word == null || !word.matches(wordRegex)) {
            return false;
        }
        return true;
    }


}
