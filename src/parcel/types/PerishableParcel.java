package parcel.types;

import parcel.Parcel;

// скоропортящаяся
public class PerishableParcel extends Parcel {

    private int timeToLive;
    private static final double BASE_RATE = 3.0;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    private boolean isExpired(int currentDay) {
        return currentDay > (sendDay + timeToLive);
    }

    @Override
    protected double getBaseRate() {
        return BASE_RATE;
    }
}
