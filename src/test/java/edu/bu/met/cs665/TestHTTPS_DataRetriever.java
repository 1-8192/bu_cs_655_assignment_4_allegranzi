/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: TestHTTPS_DataRetriever.java
 * Description: Test class for the HTTPS Data retriever.
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
public class TestHTTPS_DataRetriever {

  // The below are needed to test output to system.
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  private HTTPS_DataRetriever httpsDataRetriever;

  @Before
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
    Customer customer = new Customer(1, "Jane", "Doe", 25);
    httpsDataRetriever = new HTTPS_DataRetriever();
    httpsDataRetriever.setCustomer(customer);
  }

  @Test
  public void testPrintCustomer() {
    httpsDataRetriever.printCustomer(1);
    Assert.assertEquals("Customer Data: \n" +
          "ID: 1\n" +
          "First Name: Jane\n" +
          "Last Name: Doe\n" +
          "Age: 25", outputStreamCaptor.toString()
          .trim());

    outputStreamCaptor.reset();

    httpsDataRetriever.printCustomer(3);
    Assert.assertEquals("Data for customer with ID 3 not loaded yet."
          , outputStreamCaptor.toString()
          .trim());
  }

  @Test
  public void testGetCustomer_HTTPS() {
    outputStreamCaptor.reset();
    httpsDataRetriever.getCustomer_HTTPS(1);
    Assert.assertEquals("Establishing secure connection over HTTPS..."
          , outputStreamCaptor.toString()
                .trim());
  }
}
