package parcel;

public abstract class Parcel {

    private final String description;
    private final double weight;
    private final String deliveryAddress;
    private final int sendDay;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    protected abstract double getBaseRate();

    public double calculateDeliveryCost() {
        return weight * getBaseRate();
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
    }

    public double getWeight() {
        return weight;
    }
}
