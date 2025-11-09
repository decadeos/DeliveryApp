import org.junit.Test;
import static org.junit.Assert.*;

import parcel.ParcelBox;
import parcel.types.StandardParcel;

public class ParcelBoxTest {

    @Test
    public void addParcelWithinLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5.0);

        StandardParcel ok = new StandardParcel("Цветочки", 3.0, "Мой дом", 1);
        box.addParcel(ok);

        assertEquals(1, box.getAllParcels().size());
        assertEquals("Цветочки", box.getAllParcels().get(0).getDescription());
    }

    @Test
    public void doNotAddParcelOverLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5.0);

        StandardParcel heavy = new StandardParcel("Диск шансона", 6.0, "Тверь", 1);
        box.addParcel(heavy);

        assertTrue(box.getAllParcels().isEmpty());
    }
}
