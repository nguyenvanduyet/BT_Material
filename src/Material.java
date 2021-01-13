import java.time.LocalDate;

public abstract class Material {
    private String id;
    private String name;
    private LocalDate dateOfManufacture;
    private double price;
    public static LocalDate today= LocalDate.now();

    public Material(){
    }
    public Material(String id, String name, LocalDate dateOfManufacture, double price) {
        this.id = id;
        this.name = name;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public double getPrice() {
        return price;
    }
    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", price=" + price +
                '}';
    }
}
