package railway.price_calculation.domain.price;

import lombok.*;
import railway.price_calculation.domain.common.Amount;

/**
 * トータルの大人料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class TotalAdultPrice {
  @Getter private final Amount amount;

  public static TotalAdultPrice from(Amount amount) {
    return new TotalAdultPrice(amount);
  }
}
