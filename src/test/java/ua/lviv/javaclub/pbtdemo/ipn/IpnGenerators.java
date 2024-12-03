package ua.lviv.javaclub.pbtdemo.ipn;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Provide;
import net.jqwik.api.domains.DomainContextBase;

public class IpnGenerators extends DomainContextBase {
    @Provide
    public Arbitrary<String> datePart() {
        return Arbitraries.strings().numeric().ofLength(5);
    }

    @Provide
    public Arbitrary<String> orderPart() {
        return Arbitraries.strings().numeric().ofLength(4);
    }

    @Provide
    public Arbitrary<String> controlPart() {
        return Arbitraries.strings().numeric().ofLength(1);
    }

    @Provide
    public Arbitrary<Ipn> ipn() {
        return Combinators
                .combine(datePart(), orderPart(), controlPart())
                .as(Ipn::new);
    }
}
