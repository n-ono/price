package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;
import railway.price_calculation.domain.common.TripType;

import static org.junit.jupiter.api.Assertions.*;

class TotalPriceCalculationDomainServiceTest {
  @Test
  public void calculateForOneWayTrip() {
    TotalPrice actual =
        TotalPriceCalculationDomainService.calculate(
            FixtureFareValue.get(8910),
            FixtureSuperExpressSurchargeValue.get(5490),
            FixturePassengerValue.get(1, 2),
            FixtureComplimentaryPassengerValue.get(0, 0),
            TripType.ONE_WAY);

    assertEquals(FixtureTotalPriceValue.get(36000), actual);
  }

  @Test
  public void calculateForRoundTrip() {
    TotalPrice actual =
        TotalPriceCalculationDomainService.calculate(
            FixtureFareValue.get(8910),
            FixtureSuperExpressSurchargeValue.get(5490),
            FixturePassengerValue.get(1, 2),
            FixtureComplimentaryPassengerValue.get(0, 0),
            TripType.ROUND);

    assertEquals(FixtureTotalPriceValue.get(72000), actual);
  }
}
