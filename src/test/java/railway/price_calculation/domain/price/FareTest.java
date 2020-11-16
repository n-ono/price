package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FareTest {
  @Test
  public void plus() {
    assertEquals(
        FixturePriceValue.get(30),
        FixtureFareValue.get(10).plus(FixtureSuperExpressSurchargeValue.get(20)));
  }
}
