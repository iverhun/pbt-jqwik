package ua.lviv.javaclub.pbtdemo.ipn;

import lombok.Getter;

@Getter
public class Ipn {
    private final String datePart;
    private final String orderPart;
    private final String controlPart;

    public Ipn(String datePart, String orderPart, String controlPart) {
        if (datePart.length() != 5 || orderPart.length() != 4 || controlPart.length() != 1) {
            throw new IllegalArgumentException("Invalid IPN parts length");
        }

        if (!datePart.matches("\\d{5}") || !orderPart.matches("\\d{4}") || !controlPart.matches("\\d")) {
            throw new IllegalArgumentException("Invalid IPN parts format");
        }

        this.datePart = datePart;
        this.orderPart = orderPart;
        this.controlPart = controlPart;
    }

    public String toString() {
        return datePart + orderPart + controlPart;
    }
}
