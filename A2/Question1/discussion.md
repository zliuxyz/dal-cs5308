## Q1

1. The code violates the "dependency inversion principle".

2. According to the "dependency inversion principle", we know that high level modules should not
   depend on low level modules. Both of them should depend on abstractions. Also, abstraction
   should not depend on details, but details should depend on abstraction. The Employer class
   depends on the HourlyWorker and SalaryWorker classes, it needs to be changed when there are changes
   made to the HourlyWorker and SalaryWorker classes.

3. See code.
