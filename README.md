# Flat-Electricity-Management-
1.	Create Account class with the details , Account Number, Name, Balance. Account number need to be generated automatically ( use static with the initial value as 20100). Create another class Transaction with the details Account number, amount transacted, Credit/ debit, date (as string). Write appropriate functions to perform the following:
•	Create N objects for Account class. Use constructor to initialize values. Minimum balance should be 1000 while creating objects.
•	Create user interaction method to ask for either “withdraw or deposit”. Then ask for account number, amount, and date. Store the transaction as account number, amount, “credit” if it is deposit and “debit” If it is withdrawal and date in Transaction class object.  Update the amount in the corresponding Account class object. While withdrawal check for the minimum balance after deducting.
•	Display total amount of credit and debit in every date.
•	Display the transaction history of a particular account number.
•	Display all the credit details and debit details separately in the ascending order of the amount. Print two separate list.

2.	Create class for Electricity for N flats of an apartment. The required details are Flat number, EB meter number, Owner name, Previous month reading( in units), current month reading ( in Units), amount. Except amount and EB meter number remaining values will be accepted from the user. EB meter number could be random number generated between 10000 to 20000. Amount will be calculates as below:
0-100  Minimum charges =100
100-500  2.5 ₹  per unit
500-1000   5.0 ₹ per unit
Above 1000 7.5 ₹ per unit

Write appropriate functions to perform the following:
•	Display the flat and owner details who paid maximum and minimum EB charges.
•	Display the average amount paid by all flats in each floor. Floor will be identified from the first digit of a flat number.  For 1001 – first floor , 2005 – second floor, 5010- Fifth floor. Display the floor wise details.
•	Display the Flat number, EB amount along with the meter number in the ascending order of the meter number.
