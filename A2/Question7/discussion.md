1. The code violates the "Liskov Substitution Principle"

2. The "Liskov Substitution Principle" states that objects in a program should be replaceable with
   instances of their subtypes without altering the correctness of that program. In our code, we
   should be able to swap out an object that is of type IInsect with another object of type IInsect
   without altering the correctness of our program. However, this is not the case. The object of type
   AquaticInsect cannot fly, and the object of type FlyingInsect cannot swim. Let's say that our program
   needs to replace an AquaticInsect object with a FlyingInsect object, and the program will be incorrect,
   if the program needs to make the IInsect object to swim, since the FlyingInsect object cannot fly, and
   vice versa.

3. See code.