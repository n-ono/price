package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixtureFareValue {
  public static Fare get(int n) {
    return Fare.from(Amount.from(n));
  }
}
