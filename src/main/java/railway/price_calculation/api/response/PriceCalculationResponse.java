package railway.price_calculation.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PriceCalculationResponse {
  @Getter private final int price;
}
