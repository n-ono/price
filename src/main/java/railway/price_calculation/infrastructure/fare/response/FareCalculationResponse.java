package railway.price_calculation.infrastructure.fare.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FareCalculationResponse {
  @Getter @Setter private int value;
}
