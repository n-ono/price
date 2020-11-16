package railway.price_calculation.infrastructure.discount.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountCalculationResponse {
  @Getter @Setter private int children;
  @Getter @Setter private int adults;
}
