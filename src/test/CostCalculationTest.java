import org.junit.Test;
import static org.junit.Assert.*;

import parcel.types.StandardParcel;
import parcel.types.FragileParcel;
import parcel.types.PerishableParcel;

public class CostCalculationTest {

    // без дельты не работают
    @Test
    public void standardParcelCost() {
        StandardParcel parcel = new StandardParcel("Документы", 2.0, "Москва", 1);
        assertEquals(2.0 * 2.0, parcel.calculateDeliveryCost(), 0.0001);
    }

    @Test
    public void fragileParcelCost() {
        FragileParcel parcel = new FragileParcel("Ваза", 1.5, "Казань", 1);
        assertEquals(1.5 * 4.0, parcel.calculateDeliveryCost(), 0.0001);
    }

    @Test
    public void perishableParcelCost() {
        PerishableParcel parcel = new PerishableParcel("Новая станция метро", 3.0,
                        "СПб", 1, 2);
        assertEquals(3.0 * 3.0, parcel.calculateDeliveryCost(), 0.0001);
    }
}
