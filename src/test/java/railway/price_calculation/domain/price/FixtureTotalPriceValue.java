package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixtureTotalPriceValue {
  public static TotalPrice get(int n) {
    return TotalPrice.from(Amount.from(n));
  }
}
