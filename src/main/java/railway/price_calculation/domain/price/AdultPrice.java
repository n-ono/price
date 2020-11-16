package railway.price_calculation.domain.price;

import lombok.*;
import railway.price_calculation.domain.common.Adults;
import railway.price_calculation.domain.common.Amount;

/**
 * 大人 1 人分の料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdultPrice {
  @Getter private final Amount amount;

  public static AdultPrice from(Amount amount) {
    return new AdultPrice(amount);
  }

  public AdultPrice forRoundTrip() {
    return new AdultPrice(amount.twice());
  }

  public TotalAdultPrice multiply(Adults adults) {
    return TotalAdultPrice.from(amount.multiply(adults.getNumbers()));
  }
}
