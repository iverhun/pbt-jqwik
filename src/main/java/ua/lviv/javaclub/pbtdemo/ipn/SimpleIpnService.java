package ua.lviv.javaclub.pbtdemo.ipn;

import java.time.LocalDate;

import static org.apache.commons.lang3.math.NumberUtils.*;

public class SimpleIpnService implements IpnService<String> {
    private static final LocalDate BASE_DATE = LocalDate.of(1899, 12, 31);

    public boolean isValid(String ipn) {
        return ipn != null && ipn.length() == 10 && isDigits(ipn);
    }

    public LocalDate getBirthDate(String ipn) {
        return BASE_DATE.plusDays(Integer.parseInt(ipn.substring(0, 5)));
    }

    public Gender getGender(String ipn) {
        return ipn.charAt(8) % 2 == 0 ? Gender.FEMAIL : Gender.MALE;
    }
}
