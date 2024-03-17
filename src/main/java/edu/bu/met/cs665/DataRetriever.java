package edu.bu.met.cs665;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class DataRetriever {

  protected Customer customer;

  protected final String fileName = "src/main/java/edu/bu/met/cs665/customersFakeDB.txt";

  public void printCustomer(int customerId) {
    System.out.println("Customer Data: \n" + customer.toString());
  }

  protected void getCustomerFromDB(int customerId) {
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

  protected void establishConnection() {
  }
}
