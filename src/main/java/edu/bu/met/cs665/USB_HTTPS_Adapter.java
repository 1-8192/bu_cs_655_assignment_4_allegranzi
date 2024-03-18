/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: USB_HTTPS_Adapter.java
 * Description: Adapter class that allows legacy use of getCustomer_USB()
 * method through an HTTPS connection.
 */

package edu.bu.met.cs665;

/**
 * Adapter class that allows legacy use of getCustomer_USB()
 * method through an HTTPS connection.
 */
public class USB_HTTPS_Adapter implements CustomerData_USB {

  /**
   * New HTTPS system to load customer data.
   */
  private final CustomerData_HTTPS customerDataHttps;

  /**
   * Constructor for class takes in a concrete implementation
   * of the CustomerData_HTTPS interface.
   *
   * @param customerDataHttps interface for HTTPS connections.
   */
  USB_HTTPS_Adapter(CustomerData_HTTPS customerDataHttps) {
    this.customerDataHttps = customerDataHttps;
  }

  /**
   * Interface method to display customer data.
   *
   * @param customerId the id.
   */
  @Override
  public void printCustomer(int customerId) {
    customerDataHttps.printCustomer(customerId);
  }

  /**
   * Interface method to load customer data from the DB. We are calling
   * the HTTPS data retriever from within the function, which is
   * the core adapter pattern benefit.
   *
   * @param customerId the id.
   */
  @Override
  public void getCustomer_USB(int customerId) {
    customerDataHttps.getCustomer_HTTPS(customerId);
  }
}
