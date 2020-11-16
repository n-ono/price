package railway.price_calculation.domain.price;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import railway.price_calculation.domain.common.Adults;
import railway.price_calculation.domain.common.Children;

/**
 * 申込があった乗客数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Passenger {
  @Getter private final Children children;
  @Getter private final Adults adults;

  public ChargedPassenger exclude(ComplimentaryPassenger complimentaryPassenger) {
    return new ChargedPassenger(
        children.minus(complimentaryPassenger.getChildren()),
        adults.minus(complimentaryPassenger.getAdults()));
  }
}
