package railway.price_calculation.domain.discount;

import railway.price_calculation.domain.price.Passenger;
import railway.price_calculation.domain.price.ComplimentaryPassenger;

public interface DiscountRepository {
  ComplimentaryPassenger calculate(Passenger passenger);
}
