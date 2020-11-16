package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalChildPriceTest {
  @Test
  public void plus() {
    assertEquals(
        FixtureTotalPriceValue.get(50),
        FixtureTotalChildPriceValue.get(10).plus(FixtureTotalAdultPriceValue.get(40)));
  }
}
