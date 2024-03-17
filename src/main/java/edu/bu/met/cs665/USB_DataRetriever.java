package edu.bu.met.cs665;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class USB_DataRetriever extends DataRetriever implements CustomerData_USB {

  public USB_DataRetriever() {
  }

  public void printCustomer(int customerId) {
    System.out.println("Customer Data: \n" + customer.toString());
  }

  public void getCustomer_USB(int customerId) {
    getCustomerFromDB(customerId);
  }

  @Override
  protected void establishConnection() {
    System.out.println("Establishing a local connection vis USB... \n");
  }
}
