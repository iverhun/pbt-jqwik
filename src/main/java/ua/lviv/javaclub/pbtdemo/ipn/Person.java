package ua.lviv.javaclub.pbtdemo.ipn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Person {
    private final String fullName;
    private final Ipn ipn;

}
