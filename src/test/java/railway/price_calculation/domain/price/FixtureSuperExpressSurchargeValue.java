package railway.price_calculation.domain.price;

import railway.price_calculation.domain.common.Amount;

public class FixtureSuperExpressSurchargeValue {
  public static SuperExpressSurcharge get(int n) {
    return SuperExpressSurcharge.from(Amount.from(n));
  }
}
