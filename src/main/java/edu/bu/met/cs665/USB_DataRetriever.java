package edu.bu.met.cs665;

public class USB_DataRetriever implements CustomerData_USB {


  public void printCustomer(int customerId) {
    System.out.println("The customer ID is: " + customerId);
  };

  public void getCustomer_USB(int customerId) {
    System.out.println("Establishing secure connection over USB... \n");
    System.out.println("Data for Customer ID " + customerId + ": \n");
  };
}
