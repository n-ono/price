package railway.price_calculation.infrastructure.super_express_surcharge.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuperExpressSurchargeCalculationResponse {
  @Getter @Setter private int superExpressSurcharge;
}
