## Q2

1. The code violates the "Interface Segregation Principle"

2. The "Interface Segregation Principle" says that many client-specific interfaces are better than one
   general-purpose interface. For Book class, there is no need for it to have "GetPlayTime" and
   "GetCastList" methods. For DVD class, there is no need for it to have "GetAuthor" method.
   Therefore, the ILibraryitem interface is too generic. We need to have one interface for library item;
   one interface for book item, which extends the library item interface; one interface for DVD item,
   which extends the library item interface.

3. See code.
