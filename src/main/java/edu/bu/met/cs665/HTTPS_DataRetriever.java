package edu.bu.met.cs665;


public class HTTPS_DataRetriever extends DataRetriever implements CustomerData_HTTPS {


  public void printCustomer(int customerId) {
    System.out.println("Customer Data: \n" + customer.toString());
  };

  public void getCustomer_HTTPS(int customerId) {
    getCustomerFromDB(customerId);
  };

  @Override
  protected void establishConnection() {
    System.out.println("Establishing secure connection over HTTPS... \n");
  }
}
