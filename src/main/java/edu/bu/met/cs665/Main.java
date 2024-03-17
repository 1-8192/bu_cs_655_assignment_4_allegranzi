/**
 * Name: FIRST_NAME LAST_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Write a description for this class
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.Person;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    HTTPS_DataRetriever httpsDataRetriever = new HTTPS_DataRetriever();
    USB_DataRetriever usbDataRetriever = new USB_DataRetriever();
    USB_HTTPS_Adapter adapter = new USB_HTTPS_Adapter(httpsDataRetriever);

    // USB method.
    usbDataRetriever.getCustomer_USB(3);

    // Calling same interface method on adapter.
    adapter.getCustomer_USB(3);
  }


}
