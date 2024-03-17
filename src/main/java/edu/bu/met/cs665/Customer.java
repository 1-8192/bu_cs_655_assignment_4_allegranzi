/**
 * Name: ALESSANDRO ALLEGRANZI
 * Course: CS-665 Software Designs & Patterns
 * Date: 03/21/2024
 * File Name: Customer.java
 * Description: A class to represent Customer. It stores values read from a text file.
 */

package edu.bu.met.cs665;

/**
 * Customer class holds data read from the application database, whic in this case is fake
 * and just a text file.
 */
public class Customer {

  /**
   * Customer Id.
   */
  private int id;

  /**
   * The customer's first name.
   */
  private String firstName;

  /**
   * The customer's last name.
   */
  private String lastName;

  /**
   * The customer's age.
   */
  private int age;

  /**
   * The class constructor takes in all variables a arguments.
   *
   * @param id id.
   * @param firstName first name.
   * @param lastName last name.
   * @param age age.
   */
  public Customer(int id, String firstName, String lastName, int age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  /**
   * Getter for name, just combining into a full name.
   *
   * @return the full name.
   */
  public String getFullName() {
    return firstName + " " + lastName;
  }

  /**
   * ID getter.
   *
   * @return the id.
   */
  public int getId() {
    return id;
  }

  /**
   * Age getter.
   *
   * @return the age.
   */
  public int getAge() {
    return age;
  }

  /**
   * Overriding toString() to dislay the info neatly.
   *
   * @return the class variables.
   */
  @Override
  public String toString() {
    return "ID: " + this.id + "\n" + "First Name: " + this.firstName + "\n"
          + "Last Name: " + lastName + "\n" + "Age: " + this.age;
  }
}
