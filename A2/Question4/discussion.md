## Q4

1. The code violates the "Open/Closed Principle"

2. The "Open/Closed Principle" states that software entities (classes, modules, functions, etc.) should be
   open for extension, but closed for extension. In the code, the methods of BankAccount class are overridden
   by the subclass - USDollarAccount, so it is not closed for modification. To have "Open/Closed Principle", we
   could make an abstract class of BankAccount, and let two subclasses provide implementations.

3. See code.