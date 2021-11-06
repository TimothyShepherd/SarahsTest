package RevatureBank;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuOptions{

    public static void employeeMenu() throws InterruptedException, SQLException{
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = DAOFactory.getEmployeeDAO();

        boolean fruitLoop = true;
        while(fruitLoop){

            System.out.println("""
                    ________________________
                    Employee | Table
                    ------------------------
                    Please select an action:
                    ------------------------
                    1. Create Employee
                    2. Delete Employee
                    3. Update Employee
                    4. Show Employee by ID
                    5. List Employees
                    6. Exit
                    ------------------------
                    """);

            int choice = sc.nextInt();

            switch(choice){
                case 1 -> {
                    System.out.println("You chose: 1. Create Employee");
                    Thread.sleep(1000);
                    System.out.println("\n" + "Please enter Employee Name to be created:");
                    Employee employee = new Employee();
                    employee.setName(sc.next());
                    System.out.println("\n" + "Please enter Employee Email:");
                    employee.setEmail(sc.next());
                    dao.addEmployee(employee);
                }
                case 2 -> {
                    System.out.println("You Chose 2. Delete Employee");
                    Thread.sleep(1000);
                    System.out.println("\n" + "Enter Id to be deleted:");
                    int id = sc.nextInt();
                    dao.deleteEmployee(id);
                }
                case 3 -> {
                    System.out.println("You chose: 3. Update Employee");
                    Thread.sleep(1000);
                    System.out.println("Please enter Employee ID to be updated:");
                    Employee employee = new Employee();
                    int id = sc.nextInt();
                    System.out.println("\n" + "Please enter new Employee name:");
                    employee.setName(sc.next());
                    System.out.println("\n" + "Please enter Employee Email:");
                    employee.setEmail(sc.next());
                    dao.updateEmployee(employee, id);
                }
                case 4 -> {
                    System.out.println("You chose: 4. Show Employee by ID");
                    Thread.sleep(1000);
                    System.out.println("\n" + "Enter Employee ID to be displayed:" + "\n");
                    int empId = sc.nextInt();
                    Employee employee = dao.getEmployeeById(empId);
                    System.out.printf("%-20.20s %-20.20s %-20.20s%n",
                            "ID: " + employee.getId(),
                            "Name: " + employee.getName(),
                            "Email: " + employee.getEmail()
                    );
                    Thread.sleep(1000);
                }
                case 5 -> {
                    System.out.println("You chose: 5. List Employees");
                    Thread.sleep(1000);
                    System.out.println("\n" + "Showing employees...");
                    List<Employee> employees = dao.getEmployees();
                    for(Employee employee : employees){
                        System.out.printf("%-20.20s %-20.20s %-20.20s%n",
                                "ID: " + employee.getId(),
                                "Name: " + employee.getName(),
                                "Email: " + employee.getEmail()
                        );
                    }
                    Thread.sleep(1000);
                }
                case 6 -> {
                    System.out.println("\n" + "Thank you.");
                    Thread.sleep(1000);
                    fruitLoop = false;
                }
                default -> {
                    System.out.println("Invalid selection.");
                    Thread.sleep(1000);
                    System.out.println("\n");
                }
            }
        }
    }
}
