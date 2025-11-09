import parcel.Parcel;
import parcel.ParcelBox;
import parcel.Trackable;
import parcel.types.FragileParcel;
import parcel.types.PerishableParcel;
import parcel.types.StandardParcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Простите, я прошляпила видимо ссылку для форка, поэтому отправлю архивом
// но если что вот https://github.com/decadeos/DeliveryApp
public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(10.0);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(5.0);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(8.0);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateTrackableStatuses();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус отслеживаемых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Вы выбрали опцию добавления посылки. Запишите через Enter следующее: \n" +
                "Название, Вес, Адрес назначения, день отправки");

        String description = scanner.nextLine().trim();
        double weight = Double.parseDouble(scanner.nextLine().trim());
        String deliveryAddress = scanner.nextLine().trim();
        int sendDay = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Выберете тип посылки: StandardParcel, FragileParcel, PerishableParcel");
        String type = scanner.nextLine().trim();
        switch (type) {
            case "StandardParcel":
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                System.out.println("Стандартная посылка добавлена!");
                break;
            case "FragileParcel":
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                System.out.println("Хрупкая посылка добавлена!");
                break;
            case "PerishableParcel":
                System.out.println("Также запишите сколько дней может храниться посылка");
                int timeToLive = Integer.parseInt(scanner.nextLine().trim());
                PerishableParcel perishableParcel
                        = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                System.out.println("Скоропортящаяся посылка добавлена!");
                break;
            default:
                System.out.println("Такого типа посылок мы еще не придумали");
        }
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Нет посылок для отправки.");
            return;
        }

        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        // allParcels.clear(); // неочевидно клирить или нет
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        double allCost = 0;
        for (Parcel parcel : allParcels) {
            allCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + allCost);
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

    public static void updateTrackableStatuses() {
        if (trackableParcels.isEmpty()) {
            System.out.println("Нет посылок с трекингом.");
            return;
        }

        System.out.println("Введите новое местоположение для всех отслеживаемых посылок:");
        String newLocation = scanner.nextLine().trim();

        for (Trackable trackable : trackableParcels) {
            trackable.reportStatus(newLocation);
        }
    }

    public static void showBoxContents() {
        System.out.println("Выберите коробку: standardBox, fragileBox, perishableBox");
        String box = scanner.nextLine().trim();
        switch (box) {
            case "standardBox":
                printBox(standardBox.getAllParcels());
                return;
            case "fragileBox":
                printBox(fragileBox.getAllParcels());
                return;
            case "perishableBox":
                printBox(perishableBox.getAllParcels());
                return;
            default:
                System.out.println("Такого типа коробок мы еще не придумали");
        }

    }

    private static void printBox(List<? extends Parcel> parcels) {
        if (parcels.isEmpty()) {
            System.out.println("Коробка пустая");
            return;
        }

        for (Parcel parcel : parcels) {
            System.out.println("Посылка: " + parcel.getDescription());
        }
    }

}
