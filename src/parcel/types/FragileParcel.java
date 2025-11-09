package parcel.types;

import parcel.Parcel;

// хрупкая
public class FragileParcel extends Parcel {

    private static final double BASE_RATE = 4.0;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обернута в защитную пленку");
    }

    @Override
    protected double getBaseRate() {
        return BASE_RATE;
    }

}
