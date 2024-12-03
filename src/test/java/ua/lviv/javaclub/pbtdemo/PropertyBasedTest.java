package ua.lviv.javaclub.pbtdemo;

import net.jqwik.api.*;
import org.assertj.core.api.Assertions;

public class PropertyBasedTest {
    MathService mathService = new MathService();
    StringsService stringsService = new StringsService();

    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        Assume.that(anInteger != Integer.MIN_VALUE);
        return Math.abs(anInteger) >= 0;
    }

    @Property
    boolean nonNegativeSums(@ForAll int a, @ForAll int b) {
        // Assume
        return mathService.sum(a, b) >= a;
    }

    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll String string1, @ForAll String string2) {
        String conc = stringsService.concat(string1, string2);
        Assertions.assertThat(conc.length()).isGreaterThanOrEqualTo(string1.length());
        Assertions.assertThat(conc.length()).isGreaterThanOrEqualTo(string2.length());
    }

    @Property
    void functionValue(@ForAll("integers") int anInteger) {
        Assertions.assertThat(1/(((int)Math.sqrt(anInteger)) - 25)).isGreaterThanOrEqualTo(-25);
    }

    @Provide
    Arbitrary<Integer> integers() {
        return Arbitraries.integers().between(0, 100000);
    }

    //
//    @Example
//    boolean exampleForNonNegativeSums() {
//        return nonNegativeSums(1, 2);
//    }
//
//
//    @Property
//    boolean validEmails(@ForAll("emails") String email) {
//        return email.contains("@");
//    }
//
//    @Provide
//    Arbitrary<String> emails() {
//        return Arbitraries.strings()
//                .withCharRange('a', 'z')
//                .ofMinLength(5)
//                .ofMaxLength(10)
//                .map(s -> s + "@example.com");
//    }
}
