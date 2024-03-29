
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | ALESSANDRO ALLEGRANZI      |
| Date         | 03/21/2024                 |
| Course       | Spring                     |
| Assignment # | 4                          |

# Assignment Overview


This assignment revolves around building an application for a company using two systems to access customer data. 
They are a legacy system, which relies on accessing binary files via USB connection, and a new system, which accesses 
data securely through a REST API over HTTPS connections. The legacy interface is CustomerData_USB, and the new interface
is CustomerData_HTTPS. The application needs to support legacy data loading through USB via the new interface without 
breaking. In response to the need for integrating an outdated legacy system with a modern customer data access system, 
an Adapter design pattern was employed to bridge the gap between the two separate interfaces. Using the adapter, legacy
connections vis USB can still be supported using the new HTTPS interface.

Given that the concrete classes implementing the USB and HTTPS interfaces mostly loaded data similarly, aside
from the connection type, a Template Method pattern was also implemented make the code more DRY. The application does 
not feature a UI or graphical interface, but rigorous unit tests are included in the repository. 
Additionally, the main class implements some tests that print out results to screen. A text file containing dummy customer
data stands in for an actual database layer that the various DataRetriever classes can load from. The customer data is
loaded into a Customer java class.

Screenshot:
![screen grab](images/screenshot.png)

# GitHub Repository Link:
https://github.com/1-8192/bu_cs_655_assignment_4_allegranzi

# Implementation Description 

## Diagram:

![UML Diagram](diagrams/assignment_4.drawio.pdf)

For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.

The implementation used is flexible due to the use of interfaces and class hierarchy. If any other connection types for
accessing customer data were added, it would be easy to create another adapter for the HTTPS interface following the example
adapter already created. Also, if the system ever evolved to where HTTPS connection were outdated, a new connection interface like
CustomerDataHTTPS could be added, and adapters could be purposed for USB and HTTPS connections to continue supporting legacy
retrieval methods. 

Additionally, more data retrievers classes can easily be added by extending the super class and modifying the customer data
loading template method. Removing objects should also be simple as most dependencies are based on implementing interfaces rather than
on concrete classes directly.

- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.

The implementation uses clear interfaces and widely used design patterns to ensure readability and ease of understanding. The classes
are descriptively named, and the adapter class sets up the adapter relationship simply and clearly. The DataRetriever abstract class
defines the basic functionality and attributes for any concrete child classes that extend it.

- Describe how you have avoided duplicated code and why it is important.

One example of avoiding duplicate code was my use of an abstract superclass DataRetriever and the template method pattern.
The concrete HTTPS and USB interface classes shared basically the same methods, aside from how the connection is established,
so I avoided writing out the same code in both classes by moving into the abstract class' template method, and only implementing
the connection type-specific messages in the child classes. 

- If applicable, mention any design patterns you have used and explain why they were
chosen.

The main pattern I used to solve the assignment was the Adapter pattern. It seemed perfect given that the 
scenario featured two different interfaces, one of which was from a legacy system. The USB_HTTPS_Adapter class is 
the adapter. It implements the CustomerData_HTTPS interface, and instantiates a concrete implementation of CustomerData_USB
interface as a class variable. When getCustomerData_HTTPS is called, the adapter uses the class variable's 
getCustomer_USB method to load customer data through USB, thus preserving a legacy implementation through the modern HTTPS
interface.

I also used the template method pattern. In order to reduce duplicate code, I created a DataRetriever abstract superclass 
that both concrete implementations of the CustomerData_USB and CustomerData_HTTPS interfaces extend. The abstract class defines
a getCustomerFromDB template method that calls an establishConnection() method the child classes implement based on the 
USB or HTTPS connection type.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`

## Running the Application

### From an IDE

Open the Main.java class file, and using your IDE UI run the class. In IntelliJ there is a "play" button.




