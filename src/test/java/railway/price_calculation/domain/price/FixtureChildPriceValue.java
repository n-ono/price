package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixtureChildPriceValue {
  public static ChildPrice get(int n) {
    return ChildPrice.from(Amount.from(n));
  }
}
