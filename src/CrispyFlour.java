import java.time.LocalDate;

public  class CrispyFlour extends Material implements Discount{
    private double quantity;

    public CrispyFlour(String id, String name, LocalDate dateOfManufacture, double price, double quantity) {
        super(id, name, dateOfManufacture, price);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity*getPrice();
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getDateOfManufacture().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        if (getExpiryDate().isAfter(today.plusMonths(4))){
            return getPrice()*0.8;
        }else if (getExpiryDate().isAfter(today.plusMonths(2))){
            return getPrice()*0.6;
        }
        else return getPrice()*0.9;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +super.toString() +
                "quantity=" + quantity +
                '}';
    }
}
