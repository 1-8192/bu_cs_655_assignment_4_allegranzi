/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: TestUSB_HTTPS_Adapter.java
 * Description: Test class for the adapter class.
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
 *
 * The test in this class is testing the main adapter functionality.
 */
public class TestUSB_HTTPS_Adapter {

  // The below are needed to test output to system.
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  private HTTPS_DataRetriever httpsDataRetriever;

  private USB_HTTPS_Adapter adapter;

  @Before
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
    Customer customer = new Customer(1, "Jane", "Doe", 25);
    httpsDataRetriever = new HTTPS_DataRetriever();
    httpsDataRetriever.setCustomer(customer);
    adapter = new USB_HTTPS_Adapter(httpsDataRetriever);
  }

  /**
   * Testing that we print a HTTPS connection even though we are calling the
   * legacy USB load method.
   */
  @Test
  public void testGetCustomer_HTTPS() {
    outputStreamCaptor.reset();
    adapter.getCustomer_USB(1);
    Assert.assertEquals("Establishing secure connection over HTTPS..."
          , outputStreamCaptor.toString()
                .trim());
  }
}