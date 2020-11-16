package railway.price_calculation.domain.price;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import railway.price_calculation.domain.common.Amount;

/**
 * 1 人分の料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Price {
  private final Amount amount;

  public static Price from(Amount amount) {
    return new Price(amount);
  }

  public ChildPrice forChild() {
    return ChildPrice.from(amount.half());
  }

  public AdultPrice forAdult() {
    return AdultPrice.from(amount);
  }
}
