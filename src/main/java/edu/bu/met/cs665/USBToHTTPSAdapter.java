package edu.bu.met.cs665;

public class USBToHTTPSAdapter implements CustomerData_USB {

  private final CustomerData_HTTPS customerDataHttps;

  USBToHTTPSAdapter(CustomerData_HTTPS customerDataHttps) {
    this.customerDataHttps = customerDataHttps;
  }
  @Override
  public void printCustomer(int customerId) {
    System.out.println(customerId);
  };

  @Override
  public void getCustomer_USB(int customerId) {
    customerDataHttps.getCustomer_HTTPS(customerId);
  };
}
