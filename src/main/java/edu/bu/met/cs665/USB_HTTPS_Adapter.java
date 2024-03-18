/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: USB_HTTPS_Adapter.java
 * Description: Adapter class that allows legacy use of getCustomer_USB()
 * method through an HTTPS connection interface.
 */

package edu.bu.met.cs665;

/**
 * Adapter class that allows legacy use of getCustomer_USB()
 * method through an HTTPS connection interface.
 */
public class USB_HTTPS_Adapter implements CustomerData_HTTPS {

  /**
   * Legacy USB system to load customer data.
   */
  private final CustomerData_USB customerDataUsb;

  /**
   * Constructor for class takes in a concrete implementation
   * of the CustomerData_HTTPS interface.
   *
   * @param customerDataUsb interface for legacy USB connections.
   */
  USB_HTTPS_Adapter(CustomerData_USB customerDataUsb) {
    this.customerDataUsb = customerDataUsb;
  }

  /**
   * Interface method to display customer data.
   *
   * @param customerId the id.
   */
  @Override
  public void printCustomer(int customerId) {
    customerDataUsb.printCustomer(customerId);
  }

  /**
   * Interface method to load customer data from the DB. We are calling
   * the USB data retriever from within the function, which exposes the new
   * HTTPS interface and is the core adapter pattern benefit.
   *
   * @param customerId the id.
   */
  @Override
  public void getCustomer_HTTPS(int customerId) {
    customerDataUsb.getCustomer_USB(customerId);
  }
}
