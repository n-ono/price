package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixtureTotalAdultPriceValue {
  public static TotalAdultPrice get(int n) {
    return TotalAdultPrice.from(Amount.from(n));
  }
}
