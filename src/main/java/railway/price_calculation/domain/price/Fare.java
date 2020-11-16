package railway.price_calculation.domain.price;

import lombok.*;
import railway.price_calculation.domain.common.Amount;

/**
 * 1 人分の運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Fare {
  @Getter private final Amount amount;

  public static Fare from(Amount amount) {
    return new Fare(amount);
  }

  public Price plus(SuperExpressSurcharge superExpressSurcharge) {
    return Price.from(amount.plus(superExpressSurcharge.getAmount()));
  }
}
