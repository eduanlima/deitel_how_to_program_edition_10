package chapter_09_inheritance.exercice_01;

public class BasePlusComissionEmployee extends ComissionEmployee {
    private double baseSalary;

    public BasePlusComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
            double comissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, comissionRate);
        
        if (baseSalary < 0.0)
                throw new IllegalArgumentException("Base salary must be >= 0.0");
        
        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
    
    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s: %.2f", "base-salaried", super.toString(),
        "base salary", getBaseSalary());
    }
}
