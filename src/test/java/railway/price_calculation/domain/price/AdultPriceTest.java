package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;
import railway.price_calculation.domain.common.FixtureAdultsValue;

import static org.junit.jupiter.api.Assertions.*;

class AdultPriceTest {
  @Test
  public void multiply() {
    assertEquals(
        FixtureTotalAdultPriceValue.get(30),
        FixtureAdultPriceValue.get(10).multiply(FixtureAdultsValue.get(3)));
  }
}
