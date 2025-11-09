package parcel.types;

import parcel.Parcel;

// стандартная
public class StandardParcel extends Parcel {

    private static final double BASE_RATE = 2.0;

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected double getBaseRate() {
        return BASE_RATE;
    }
}
