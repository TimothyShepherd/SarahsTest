package RevatureBank;

public class DAOFactory{
    private static EmployeeDAO empDAO;
    private static CustomerDAO cusDAO;

    private DAOFactory(){
    }

    public static EmployeeDAO getEmployeeDAO(){
        if(empDAO == null){
            empDAO = new EmployeeActions();
        }
        return empDAO;
    }

//    public static CustomerDAO getCustomerDAO(){
//        if(cusDAO == null){
//            cusDAO = new CustomerActions();
//        }
//    }
}
