package point.business;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

public class Compute {

    private static final BigInteger THREE = valueOf(3);

    private static final BigInteger FIVE = valueOf(5);

    private static final BigInteger SEVEN = valueOf(7);

    private static final String FOO = "Foo";

    private static final String BAR = "Bar";

    private static final String QIX = "Qix";

    public String compute(String number) {

        return compute(number, false);
    }

    public String compute(String number, boolean keepZero) {

        boolean divByThree = false;
        boolean divByFive = false;
        boolean divBySeven = false;

        String result = "";

        BigInteger b = new BigInteger(number);

        if (b.mod(THREE).equals(BigInteger.ZERO)) {
            divByThree = true;
        }

        if (b.mod(FIVE).equals(BigInteger.ZERO)) {
            divByFive = true;
        }

        if (b.mod(SEVEN).equals(BigInteger.ZERO)){
            divBySeven = true;
        }

        if (divByThree || divByFive || divBySeven) {

            if (divByThree) {
                result = FOO;
            }

            if (divByFive) {
                result += BAR;
            }

            if (divBySeven) {
                result += QIX;
            }

        } else {

            result = number;
        }

        StringBuilder builder = new StringBuilder();

        for (char ch : number.toCharArray()) {

            if ('3' == ch) {
                builder.append(FOO);
            } else if ('5' == ch) {
                builder.append(BAR);
            } else if ('7' == ch) {
                builder.append(QIX);
            } else if (keepZero && '0' == ch) {
                builder.append("*");
            }
        }

        String temp = builder.toString();

        if (divByThree || divByFive || divBySeven) {
            result += temp;
        } else if (!temp.isEmpty()) {
            result = temp;
        }

        if (result.equals(number)) {

            result = result.replaceAll("0", "*");
        }

        return result;
    }
}