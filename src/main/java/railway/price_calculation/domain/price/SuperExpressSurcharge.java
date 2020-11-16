package railway.price_calculation.domain.price;

import lombok.*;
import railway.price_calculation.domain.common.Amount;

/**
 * 1 人分の特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SuperExpressSurcharge {
  @Getter private final Amount amount;

  public static SuperExpressSurcharge from(Amount amount) {
    return new SuperExpressSurcharge(amount);
  }
}
