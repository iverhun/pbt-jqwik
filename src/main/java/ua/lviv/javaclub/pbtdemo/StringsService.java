package ua.lviv.javaclub.pbtdemo;

public class StringsService {
    public String concat(String a, String b) {
        return a + b;
    }

    public String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public String email() {
        return "";
    }
}
