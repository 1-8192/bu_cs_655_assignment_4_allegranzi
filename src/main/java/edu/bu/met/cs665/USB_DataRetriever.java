/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: USB_DataRetriever.java
 * Description: Concrete class to retrieve data via a USB connection.
 * This is a legacy implementation and should not be used outside of examples.
 */

package edu.bu.met.cs665;

/**
 * Concrete data Retriever class that implemented CustomerData_USB to load
 * customer data through a USB connection. It also extends the
 * DataRetriever superclass and overrides the establishConnection method.
 * This is a legacy system and should not be used outside of examples.
 */
public class USB_DataRetriever extends DataRetriever implements CustomerData_USB {

  /**
   * Interface method to display customer data.
   *
   * @param customerId the id.
   */
  public void printCustomer(int customerId) {
    if (customerId == customer.getId()) {
      System.out.println("Customer Data: \n" + customer.toString());
    } else {
      System.out.println("Data for customer with ID " + customerId + " not loaded yet.");
    }
  }

  /**
   * Interface method to load customer data from the DB. It calls the
   * getCustomerFromDb template method, which in turn calls the below overriden
   * establishConnection() method.
   *
   * @param customerId the id.
   */
  public void getCustomer_USB(int customerId) {
    getCustomerFromDb(customerId);
  }

  /**
   * Establishes a USB connection.
   */
  @Override
  protected void establishConnection() {
    System.out.println("Establishing a local connection via USB... \n");
  }
}
