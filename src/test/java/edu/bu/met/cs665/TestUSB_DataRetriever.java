/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: TestUSB_DataRetriever.java
 * Description: Test class for the USB Data retriever.
 */

package edu.bu.met.cs665;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This class really only prints to console, but I found a way to test println()
 * here: https://www.baeldung.com/java-testing-system-out-println.
 */
public class TestUSB_DataRetriever {

  // The below are needed to test output to system.
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  private USB_DataRetriever usbDataRetriever;

  @Before
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
    Customer customer = new Customer(1, "Jane", "Doe", 25);
    usbDataRetriever = new USB_DataRetriever();
    usbDataRetriever.setCustomer(customer);
  }

  @Test
  public void testPrintCustomer() {
    usbDataRetriever.printCustomer(1);
    Assert.assertEquals("Customer Data: \n" +
          "ID: 1\n" +
          "First Name: Jane\n" +
          "Last Name: Doe\n" +
          "Age: 25", outputStreamCaptor.toString()
          .trim());

    outputStreamCaptor.reset();

    usbDataRetriever.printCustomer(3);
    Assert.assertEquals("Data for customer with ID 3 not loaded yet."
          , outputStreamCaptor.toString()
                .trim());
  }

  @Test
  public void testGetCustomer_HTTPS() {
    outputStreamCaptor.reset();
    usbDataRetriever.getCustomer_USB(1);
    Assert.assertEquals("Establishing a local connection via USB..."
          , outputStreamCaptor.toString()
                .trim());
  }
}
