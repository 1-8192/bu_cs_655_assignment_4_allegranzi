/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: TestCustomer.java
 * Description: Test class for Customer.
 */

package edu.bu.met.cs665;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Customer.
 */
public class TestCustomer {

  private Customer customer;

  @Before
  public void setUp() {
    customer = new Customer(1, "Jane", "Doe", 30);
  }

  @Test
  public void testGetFullName() {
    assertEquals("Jane Doe", customer.getFullName());
  }

  @Test
  public void testGetId() {
    assertEquals(1, customer.getId());
  }

  @Test
  public void testGetAge() {
    assertEquals(30, customer.getAge());
  }

  @Test
  public void testToString() {
    String expected = "ID: 1\nFirst Name: Jane\nLast Name: Doe\nAge: 30";
    assertEquals(expected, customer.toString());
  }
}
