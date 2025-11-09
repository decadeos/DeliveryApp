package parcel.types;

import parcel.Parcel;

// скоропортящаяся
public class PerishableParcel extends Parcel {

    private final int timeToLive;
    private static final double BASE_RATE = 3.0;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > (getSendDay() + timeToLive);
    }

    @Override
    protected double getBaseRate() {
        return BASE_RATE;
    }
}
