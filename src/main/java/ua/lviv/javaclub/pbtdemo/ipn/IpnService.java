package ua.lviv.javaclub.pbtdemo.ipn;

import java.time.LocalDate;

public interface IpnService<T> {
    boolean isValid(T ipn);
    Gender getGender(T ipn);
    LocalDate getBirthDate(T ipn);
}
