package railway.price_calculation.domain.price;

import lombok.*;
import railway.price_calculation.domain.common.Amount;

/**
 * トータルの料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TotalPrice {
  @Getter private final Amount amount;

  public static TotalPrice from(Amount amount) {
    return new TotalPrice(amount);
  }
}
