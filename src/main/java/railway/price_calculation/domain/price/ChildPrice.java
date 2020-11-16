package railway.price_calculation.domain.price;

import lombok.*;
import railway.price_calculation.domain.common.Amount;
import railway.price_calculation.domain.common.Children;

/**
 * 子供 1 人分の料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChildPrice {
  @Getter private final Amount amount;

  public static ChildPrice from(Amount amount) {
    return new ChildPrice(amount);
  }

  public ChildPrice forRoundTrip() {
    return new ChildPrice(amount.twice());
  }

  public TotalChildPrice multiply(Children children) {
    return TotalChildPrice.from(amount.multiply(children.getNumbers()));
  }
}
