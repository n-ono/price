package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
  @Test
  public void forChild() {
    assertEquals(FixtureChildPriceValue.get(5000), FixturePriceValue.get(10010).forChild());
  }

  @Test
  public void forAdult() {
    assertEquals(FixtureAdultPriceValue.get(10010), FixturePriceValue.get(10010).forAdult());
  }
}
