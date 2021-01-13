import java.time.LocalDate;

public class Meat extends Material implements Discount{
    private double weight;

    public Meat(String id, String name, LocalDate dateOfManufacture, double price, double weight) {
        super(id, name, dateOfManufacture, price);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight*getPrice();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getDateOfManufacture().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        if (getExpiryDate().isAfter(today.plusDays(5))){
            return getPrice()*0.7;
        }else  if(getExpiryDate().isAfter(today.plusDays(3))){
            return getPrice()*0.5;
        }
        else {
            return getPrice()*0.1;
        }
        }
}
