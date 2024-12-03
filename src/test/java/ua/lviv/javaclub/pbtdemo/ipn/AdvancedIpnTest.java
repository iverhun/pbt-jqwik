package ua.lviv.javaclub.pbtdemo.ipn;

import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.constraints.UseType;
import net.jqwik.api.domains.Domain;
import org.assertj.core.api.Assertions;

public class AdvancedIpnTest {
    AdvancedIpnService ipnService = new AdvancedIpnService();

    @Property(tries = 100, seed = "4026750586455891985" )
    @Domain(IpnGenerators.class)
    void validPersonWithIpn(@ForAll @UseType Person person) {
        Assertions.assertThat(person.getFullName()).isNotBlank();
        Assertions.assertThat(ipnService.isValid(person.getIpn())).isTrue();
    }

    @Property
    void validationOfIpn(@ForAll String datePart, @ForAll String orderPart, @ForAll String controlPart) {
        Assume.that(datePart.length() != 5);
        Assume.that(orderPart.length() != 4);
        Assume.that(controlPart.length() != 1);

        Assertions.assertThatThrownBy(() -> new Ipn(datePart, orderPart, controlPart))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid IPN parts length");
    }
}
