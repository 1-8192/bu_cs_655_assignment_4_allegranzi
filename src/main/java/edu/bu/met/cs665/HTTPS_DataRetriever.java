/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: HTTPS_DataRetriever.java
 * Description: Concrete class to retrieve data via HTTPS connection.
 */

package edu.bu.met.cs665;

/**
 * Concrete data Retriever class that implemented CustomerData_HTTPS to load
 * customer data through a secured HTTPS conneciton. It also extends the
 * DataRetriever superclass and overrides the establishConnection method.
 */
public class HTTPS_DataRetriever extends DataRetriever implements CustomerData_HTTPS {

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
  public void getCustomer_HTTPS(int customerId) {
    getCustomerFromDb(customerId);
  }

  /**
   * Establishes an HTTPS connection.
   */
  @Override
  protected void establishConnection() {
    System.out.println("Establishing secure connection over HTTPS... \n");
  }
}
