package railway.price_calculation.api;

import io.vavr.API;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railway.price_calculation.api.response.PriceCalculationResponse;
import railway.price_calculation.domain.common.*;
import railway.price_calculation.domain.discount.DiscountRepository;
import railway.price_calculation.domain.fare.FareRepository;
import railway.price_calculation.domain.price.Passenger;
import railway.price_calculation.domain.price.TotalPrice;
import railway.price_calculation.domain.super_express_surcharge.SuperExpressSurchargeRepository;
import railway.price_calculation.service.TotalPriceCalculationService;

import java.time.LocalDate;

import static io.vavr.API.$;

@RestController
@AllArgsConstructor
public class PriceCalculationApi {
  @Autowired private final TotalPriceCalculationService service;
  @Autowired private final FareRepository fareRepository;
  @Autowired private final SuperExpressSurchargeRepository superExpressSurchargeRepository;
  @Autowired private final DiscountRepository discountRepository;

  @RequestMapping(value = "/calculate", method = RequestMethod.GET)
  public PriceCalculationResponse calculate(
      @RequestParam(name = "train-type") String trainType,
      @RequestParam(name = "seat-type") String seatType,
      @RequestParam(name = "destination") String destination,
      @RequestParam(name = "trip-type") String tripType,
      @RequestParam(name = "children") int children,
      @RequestParam(name = "adults") int adults,
      @RequestParam(name = "departure-date") String departureDate) {
    TotalPrice totalPrice =
        service.calculate(
            getTrainType(trainType),
            getSeatType(seatType),
            getDestination(destination),
            getTripType(tripType),
            new Passenger(getChildren(children), getAdults(adults)),
            getDepartureDate(departureDate));
    return new PriceCalculationResponse(totalPrice.getAmount().getValue());
  }

  private TrainType getTrainType(String trainType) {
    return API.Match(trainType)
        .of(API.Case($("nozomi"), TrainType.NOZOMI), API.Case($("hikari"), TrainType.HIKARI));
  }

  private SeatType getSeatType(String seatType) {
    return API.Match(seatType)
        .of(API.Case($("free"), SeatType.FREE), API.Case($("reserved"), SeatType.RESERVED));
  }

  private Destination getDestination(String destination) {
    return API.Match(destination)
        .of(
            API.Case($("shinosaka"), Destination.SHINOSAKA),
            API.Case($("himeji"), Destination.HIMEJI));
  }

  private TripType getTripType(String tripType) {
    return API.Match(tripType)
        .of(API.Case($("one-way"), TripType.ONE_WAY), API.Case($("round"), TripType.ROUND));
  }

  private Children getChildren(int children) {
    return Children.from(Numbers.from(children));
  }

  private Adults getAdults(int adults) {
    return Adults.from(Numbers.from(adults));
  }

  private DepartureDate getDepartureDate(String departureDateTime) {
    final int year = Integer.parseInt(departureDateTime.substring(0, 4));
    final int month = Integer.parseInt(departureDateTime.substring(4, 6));
    final int dayOfMonth = Integer.parseInt(departureDateTime.substring(6, 8));
    return DepartureDate.from(LocalDate.of(year, month, dayOfMonth));
  }
}
