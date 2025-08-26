package chapter_10_polymorphism_and_interfaces;

public class PayrollSystemTest {
    public static void main(String[] args) {
        //Create objects from subclasses
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        ComissionEmployee comissionEmployee = new ComissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
        BasePlusComissionEmployee basePlusComissionEmployee = new BasePlusComissionEmployee("Bob", "Lewis", "444-444-4444", 5000, .04, 300);
        
        System.out.println("Employees processed individualy:");
        System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", comissionEmployee, "earned", comissionEmployee.earnings());
        System.out.printf("%s%n%s: $%,.2f%n%n", basePlusComissionEmployee, "earned", basePlusComissionEmployee.earnings());
        
        Employee[] employees = new Employee[4];
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = comissionEmployee;
        employees[3] = basePlusComissionEmployee;

        System.out.printf("Employees processed polymorphically:%n%n");

        for (Employee currentEmployee: employees) {
            System.out.println(currentEmployee);

            //Determines whether an element is BasePlusComissionEmployee
            if (currentEmployee instanceof BasePlusComissionEmployee) {
                //Downcast of reference from Employee to BaseComissionEmployee
                BasePlusComissionEmployee employee = (BasePlusComissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
            }

            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
        }

        //Show the type of wich object in array
        for (int j = 0; j < employees.length; j++) {
            System.out.printf("Employeen %d is a %s%n", j, employees[j].getClass().getName());
        }

    }
}
