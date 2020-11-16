package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Adults;
import railway.price_calculation.domain.common.Children;
import railway.price_calculation.domain.common.Numbers;

public class FixtureComplimentaryPassengerValue {
  public static ComplimentaryPassenger get(int children, int adults) {
    return new ComplimentaryPassenger(
        Children.from(Numbers.from(children)), Adults.from(Numbers.from(adults)));
  }
}
