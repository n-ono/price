package railway.price_calculation.infrastructure.fare;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.price_calculation.domain.common.Amount;
import railway.price_calculation.domain.common.DepartureDate;
import railway.price_calculation.domain.common.Destination;
import railway.price_calculation.domain.common.TripType;
import railway.price_calculation.domain.fare.FareRepository;
import railway.price_calculation.domain.price.Fare;
import railway.price_calculation.domain.price.Passenger;
import railway.price_calculation.infrastructure.fare.response.FareCalculationResponse;
import railway.price_calculation.infrastructure.util.InfrastructureUtility;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class FareRepositoryImpl implements FareRepository {
  public static final String URL =
      "http://fare:8080/fare_calculation/calculate?destination={destination}&trip-type={tripType}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public Fare calculate(
      Destination destination,
      TripType tripType,
      Passenger passenger,
      DepartureDate departureDate) {
    return Fare.from(
        Amount.from(
            Objects.requireNonNull(
                    restTemplate.getForObject(
                        URL,
                        FareCalculationResponse.class,
                        InfrastructureUtility.getDestination(destination),
                        InfrastructureUtility.getTripType(tripType),
                        InfrastructureUtility.getChildren(passenger),
                        InfrastructureUtility.getAdults(passenger),
                        InfrastructureUtility.getDepartureMonthDay(departureDate)))
                .getAmountValue()));
  }
}
