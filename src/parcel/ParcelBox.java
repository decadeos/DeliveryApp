package parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final double weightMax;
    private final List<T> box = new ArrayList<>();

    public ParcelBox(double weightMax) {
        this.weightMax = weightMax;
    }

    public void addParcel(T parcel) {
        if (parcel.getWeight() > weightMax) {
            System.out.println("Предупреждение: максимальный вес посылки превышен");
        } else {
            box.add(parcel);
        }
    }

    public List<T> getAllParcels() {
        return box;
    }
}
