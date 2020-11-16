package railway.price_calculation.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassengerTest {
  @Test
  public void exclude() {
    assertEquals(
        FixtureChargedPassengerValue.get(0, 1),
        FixturePassengerValue.get(1, 2).exclude(FixtureComplimentaryPassengerValue.get(1, 1)));
  }
}
