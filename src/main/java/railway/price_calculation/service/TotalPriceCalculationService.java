package railway.price_calculation.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import railway.price_calculation.domain.common.*;
import railway.price_calculation.domain.discount.DiscountRepository;
import railway.price_calculation.domain.fare.FareRepository;
import railway.price_calculation.domain.price.*;
import railway.price_calculation.domain.super_express_surcharge.SuperExpressSurchargeRepository;

@Service
@AllArgsConstructor
public class TotalPriceCalculationService {
  @Autowired private final FareRepository fareRepository;
  @Autowired private final SuperExpressSurchargeRepository superExpressSurchargeRepository;
  @Autowired private final DiscountRepository discountRepository;

  public TotalPrice calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      TripType tripType,
      Passenger passenger,
      DepartureDate departureDate) {
    Fare fare = fareRepository.calculate(destination, tripType, passenger, departureDate);
    SuperExpressSurcharge superExpressSurcharge =
        superExpressSurchargeRepository.calculate(
            trainType, seatType, destination, passenger, departureDate);
    ComplimentaryPassenger complimentaryPassenger = discountRepository.calculate(passenger);
    return TotalPriceCalculationDomainService.calculate(
        fare, superExpressSurcharge, passenger, complimentaryPassenger, tripType);
  }
}
