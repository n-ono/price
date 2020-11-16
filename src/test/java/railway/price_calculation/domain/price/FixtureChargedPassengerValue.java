package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Adults;
import railway.price_calculation.domain.common.Children;
import railway.price_calculation.domain.common.Numbers;

public class FixtureChargedPassengerValue {
  public static ChargedPassenger get(int children, int adults) {
    return new ChargedPassenger(
        Children.from(Numbers.from(children)), Adults.from(Numbers.from(adults)));
  }
}
