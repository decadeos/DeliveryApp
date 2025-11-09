package parcel.types;

import parcel.Parcel;
import parcel.Trackable;

// хрупкая
public class FragileParcel extends Parcel implements Trackable {

    private static final double BASE_RATE = 4.0;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> обернута в защитную пленку");
    }

    @Override
    protected double getBaseRate() {
        return BASE_RATE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка \"" + getDescription()
                + "\" изменила местоположение на " + newLocation);
    }
}
