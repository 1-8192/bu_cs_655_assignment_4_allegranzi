/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: Main.java
 * Description: The main executable class. Please run this to test out the application.
 */

package edu.bu.met.cs665;

/**
 * This is the Main class. Run it through your IDE to test out the app.
 */
public class Main {

  /**
   * A main method to run examples.
   * Please see the comments in code that explain the examples I have set up.
   */
  public static void main(String[] args) {
    // Setting up 3 data retrievers to display the adapter functionality.
    // One legacy USB loader, a new HTTPS loader, and an adapter.
    final HTTPS_DataRetriever httpsDataRetriever = new HTTPS_DataRetriever();
    final USB_DataRetriever usbDataRetriever = new USB_DataRetriever();
    final USB_HTTPS_Adapter adapter = new USB_HTTPS_Adapter(httpsDataRetriever);

    // Legacy USB system.
    System.out.println("// Below are results from the legacy implementation: \n");
    usbDataRetriever.getCustomer_USB(3);
    usbDataRetriever.printCustomer(3);
    System.out.println("\n");

    // New HTTPS System.
    System.out.println("// Below are results for the new HTTPS implementation: \n");
    httpsDataRetriever.getCustomer_HTTPS(2);
    httpsDataRetriever.printCustomer(2);
    System.out.println("\n");

    // Loading a customer using the USB method through the adapter. Notice it prints out
    // an HTTPS connection even though the USB method from the interface is called.
    System.out.println("// Below are results for the adapter calling the USB method. "
          + "Notice the connection type is HTTPS: ");
    adapter.getCustomer_USB(1);
    adapter.printCustomer(1);
  }
}
