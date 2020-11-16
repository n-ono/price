package railway.price_calculation.domain.common;

/**
 * 旅行区分
 * 片道 or 往復
 */
public enum TripType {
  ONE_WAY,
  ROUND;

  public boolean isOneWay() {
    return this == ONE_WAY;
  }
}
