package ua.lviv.javaclub.pbtdemo.ipn;

import java.time.LocalDate;

public class AdvancedIpnService implements IpnService<Ipn> {

    private final SimpleIpnService simpleIpnService = new SimpleIpnService();

    @Override
    public boolean isValid(Ipn ipn) {
        return simpleIpnService.isValid(ipn.toString());
    }

    @Override
    public Gender getGender(Ipn ipn) {
        return simpleIpnService.getGender(ipn.toString());
    }

    @Override
    public LocalDate getBirthDate(Ipn ipn) {
        return simpleIpnService.getBirthDate(ipn.toString());
    }
}
