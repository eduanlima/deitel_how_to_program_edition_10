package chapter_09_inheritance.exercice_01;

public class ComissionEmployee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private double grossSales;
    private double comissionRate;

    public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
            double comissionRate) {
        //Implicit call to the constructor of the class Object ocurrs here

        if (grossSales < 0.0)
                throw new IllegalArgumentException("Gross sales must be >= 0");

        if (comissionRate <= 0.0  || comissionRate >= 1.0)
                throw new IllegalArgumentException("Comission rate must be > 0.0 and < 1.0");

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.comissionRate = comissionRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
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

    public double earnings() {
        return getComissionRate() * getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
        "comission rate", getFirstName(), getLastName(),
        "social security number", getSocialSecurityNumber(),
        "gross sales", getGrossSales(),
        "comissin rate", getComissionRate());
    }
}
