package railway.price_calculation.infrastructure.discount;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.price_calculation.domain.common.Adults;
import railway.price_calculation.domain.common.Children;
import railway.price_calculation.domain.common.Numbers;
import railway.price_calculation.domain.discount.DiscountRepository;
import railway.price_calculation.domain.price.ComplimentaryPassenger;
import railway.price_calculation.domain.price.Passenger;
import railway.price_calculation.infrastructure.discount.response.DiscountCalculationResponse;
import railway.price_calculation.infrastructure.util.InfrastructureUtility;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class DiscountRepositoryImpl implements DiscountRepository {
  public static final String URL =
      "http://discount:8080/discount_calculation/calculate-complimentary-numbers?children={children}&adults={adults}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public ComplimentaryPassenger calculate(Passenger passenger) {
    DiscountCalculationResponse response =
        restTemplate.getForObject(
            URL,
            DiscountCalculationResponse.class,
            InfrastructureUtility.getChildren(passenger),
            InfrastructureUtility.getAdults(passenger));
    Objects.requireNonNull(response);
    Children children = Children.from(Numbers.from(response.getChildren()));
    Adults adults = Adults.from(Numbers.from(response.getAdults()));
    return new ComplimentaryPassenger(children, adults);
  }
}
