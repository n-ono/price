package railway.price_calculation.domain.super_express_surcharge;

import railway.price_calculation.domain.common.*;
import railway.price_calculation.domain.price.Passenger;
import railway.price_calculation.domain.price.SuperExpressSurcharge;

public interface SuperExpressSurchargeRepository {
  SuperExpressSurcharge calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      Passenger passenger,
      DepartureDate departureDate);
}
