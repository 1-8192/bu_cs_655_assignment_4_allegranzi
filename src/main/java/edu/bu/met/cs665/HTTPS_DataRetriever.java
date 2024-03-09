package edu.bu.met.cs665;

public class HTTPS_DataRetriever implements CustomerData_HTTPS {


  public void printCustomer(int customerId) {
    System.out.println("The customer ID is: " + customerId);
  };

  public void getCustomer_HTTPS(int customerId) {
    System.out.println("Establishing secure connection over HTTPS... \n");
    System.out.println("Data for Customer ID " + customerId + ": \n");
  };
}
