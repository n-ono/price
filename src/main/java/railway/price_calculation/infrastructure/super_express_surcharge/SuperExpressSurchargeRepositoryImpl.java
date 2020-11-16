package railway.price_calculation.infrastructure.super_express_surcharge;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.price_calculation.domain.common.*;
import railway.price_calculation.domain.price.Passenger;
import railway.price_calculation.domain.price.SuperExpressSurcharge;
import railway.price_calculation.domain.super_express_surcharge.SuperExpressSurchargeRepository;
import railway.price_calculation.infrastructure.super_express_surcharge.response.SuperExpressSurchargeCalculationResponse;
import railway.price_calculation.infrastructure.util.InfrastructureUtility;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class SuperExpressSurchargeRepositoryImpl implements SuperExpressSurchargeRepository {
  public static final String URL =
      "http://super-express-surcharge:8080/super_express_surcharge_calculation/calculate?train-type={trainType}&seat-type={seatType}&destination={destination}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public SuperExpressSurcharge calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      Passenger passenger,
      DepartureDate departureDate) {
    return SuperExpressSurcharge.from(
        Amount.from(
            Objects.requireNonNull(
                    restTemplate.getForObject(
                        URL,
                        SuperExpressSurchargeCalculationResponse.class,
                        InfrastructureUtility.getTrainType(trainType),
                        InfrastructureUtility.getSeatType(seatType),
                        InfrastructureUtility.getDestination(destination),
                        InfrastructureUtility.getChildren(passenger),
                        InfrastructureUtility.getAdults(passenger),
                        InfrastructureUtility.getDepartureMonthDay(departureDate)))
                .getSuperExpressSurcharge()));
  }
}
