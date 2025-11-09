import org.junit.Test;
import static org.junit.Assert.*;

import parcel.types.PerishableParcel;

public class PerishableParcelTest {

    @Test
    public void perishableNotExpiredBeforeLimit() {
        PerishableParcel parcel =
                new PerishableParcel("Молоко", 1.0, "Москва", 1, 3);

        assertFalse(parcel.isExpired(4));
    }

    @Test
    public void perishableExpiredAfterLimit() {
        PerishableParcel parcel =
                new PerishableParcel("Молоко", 1.0, "Москва", 1, 3);

        assertTrue(parcel.isExpired(5));
    }
}
