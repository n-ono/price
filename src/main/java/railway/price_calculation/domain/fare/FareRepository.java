package railway.price_calculation.domain.fare;

import railway.price_calculation.domain.common.DepartureDate;
import railway.price_calculation.domain.common.Destination;
import railway.price_calculation.domain.common.TripType;
import railway.price_calculation.domain.price.Fare;
import railway.price_calculation.domain.price.Passenger;

public interface FareRepository {
  Fare calculate(
      Destination destination, TripType tripType, Passenger passenger, DepartureDate departureDate);
}
