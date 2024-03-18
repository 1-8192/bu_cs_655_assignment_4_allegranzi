/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: DataRetriever.java
 * Description: Abstract superclass concrete data retrievers should extend.
 */

package edu.bu.met.cs665;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass concrete data retrievers should extend. The getCustomerFromDB
 * is a very light template method; child classes implement their own versions of
 * establishConnection().
 */
public abstract class DataRetriever {

  /**
   * Customer data loaded by getCustomerFromDB.
   */
  protected Customer customer;

  /**
   * Filename used to read from, represents a very simple database.
   */
  protected final String fileName = "src/main/java/edu/bu/met/cs665/customersFakeDB.txt";

  /**
   * Template method to load a customer from the DB. Child classes
   * will implement their own version of establishing a connection.
   *
   * @param customerId the id.
   */
  protected void getCustomerFromDb(int customerId) {
    establishConnection();

    List<Customer> loadedCustomers = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String firstName = parts[1];
        String lastName = parts[2];
        int age = Integer.parseInt(parts[3]);
        loadedCustomers.add(new Customer(id, firstName, lastName, age));
      }
      for (Customer currentCustomer : loadedCustomers) {
        if (currentCustomer.getId() == customerId) {
          customer = currentCustomer;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Child classes should define this based on whether connection is HTTPS
   * or USB.
   */
  protected void establishConnection() {
  }

  /**
   * Setter for customer instance. Only used for unit testing.
   *
   * @param newCustomer the customer instance.
   */
  protected void setCustomer(Customer newCustomer) {
    customer = newCustomer;
  }
}
