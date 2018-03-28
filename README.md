retail store discount billing system
======================================

Bill Amount Calculator for a Sample Retail Store

 * Following is the goal of this program
 * 
On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.
 
 * Finds the net payable amount.
 
 Few Notes :- 
 
 1. Since i have created this project using Maven, this can be imported in eclipse as a Maven Project specifying the pom file. Run [mvn clean eclipse:eclipse] to generate eclipse files for the project.
 
 2. Run [mvn clean install] to install and run all the test cases.
 
 3. Used Joda-Time for efficient Date related calculations.
 
 4. Analyzed the code using Sonar Lint for Code Quality. Clear with no issues.
 
 5. This Application uses Java 1.8 and JUnit4.10.
 