package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixtureAdultPriceValue {
  public static AdultPrice get(int n) {
    return AdultPrice.from(Amount.from(n));
  }
}
