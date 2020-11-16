package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixturePriceValue {
  public static Price get(int n) {
    return Price.from(Amount.from(n));
  }
}
