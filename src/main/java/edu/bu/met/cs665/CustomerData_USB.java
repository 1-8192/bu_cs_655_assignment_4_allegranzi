/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: CustomerData_USB
 * Description: An interface for the new system of retrieving customer data through
 * a direct USB connection.
 */

package edu.bu.met.cs665;

/**
 * An interface for the new system of retrieving customer data through
 * a direct USB connection.
 */
public interface CustomerData_USB {

  /**
   * Print customer info based on ID.
   *
   * @param customerId the id.
   */
  void printCustomer(int customerId);

  /**
   * Load customer based on ID through a USB connection.
   *
   * @param customerId the id.
   */
  void getCustomer_USB(int customerId);
}
