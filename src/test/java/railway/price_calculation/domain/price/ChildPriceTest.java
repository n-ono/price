package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;
import railway.price_calculation.domain.common.FixtureChildrenValue;

import static org.junit.jupiter.api.Assertions.*;

class ChildPriceTest {
  @Test
  public void multiply() {
    assertEquals(
        FixtureTotalChildPriceValue.get(30),
        FixtureChildPriceValue.get(10).multiply(FixtureChildrenValue.get(3)));
  }
}
