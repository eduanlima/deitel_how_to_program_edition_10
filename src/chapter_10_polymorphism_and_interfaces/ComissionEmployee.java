package chapter_10_polymorphism_and_interfaces;

public class ComissionEmployee extends Employee {
    private double grossSales;
    private double comissionRate;

    public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must be >= 0");

        if (comissionRate <= 0.0  || comissionRate >= 1.0)
                throw new IllegalArgumentException("Comission rate must be > 0.0 and < 1.0");
        
        this.grossSales = grossSales;
        this.comissionRate = comissionRate;
    }
    
    public void setGrossSales(double grossSales){
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gloss sale must be >= 0.0");

        this.grossSales = grossSales;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setComissionRate(double comissionRate) {
        if (comissionRate <= 0.0 || comissionRate >= 1.0)
            throw new IllegalArgumentException("Comission rate must be > 0.0 and < 1.0");

        this.comissionRate = comissionRate;
    }

    public double getComissionRate() {
        return comissionRate;
    }

    @Override
    public double earnings() {
        return getComissionRate() * getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
        "comission employee", super.toString(),
        "gross sales", getGrossSales(),
        "comission rate", getComissionRate());
    }
}
