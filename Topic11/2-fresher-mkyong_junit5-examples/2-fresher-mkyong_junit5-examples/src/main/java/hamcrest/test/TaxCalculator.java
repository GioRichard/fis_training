package hamcrest.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class TaxCalculator {
    public static final BigDecimal DEFAULT_TAX_RATE = BigDecimal.valueOf(18);
    public static final BigDecimal DEFAULT_DISCOUNT_RATE = BigDecimal.valueOf(10);
    public static final List AVAILABLE_TAXES = Arrays.asList("KDV", "OTV", "MTV");

    public BigDecimal calculate(BigDecimal amount, boolean hasDiscount) {
        if (amount == null) {
            return null;
        }
        //18%
        if (hasDiscount == false) {
            return amount.multiply(DEFAULT_TAX_RATE)
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        }

        //8%
        BigDecimal effectiveRate = DEFAULT_TAX_RATE.subtract(DEFAULT_DISCOUNT_RATE);
        BigDecimal tax = amount.multiply(effectiveRate)
                .divide(BigDecimal.valueOf(100), 2,RoundingMode.HALF_UP);
        return tax;
    }
}
