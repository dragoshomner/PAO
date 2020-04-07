<h1>Marketplace</h1>

Proiectul simuleaza un magazin online, in care avem clienti si produse. Structura pe care am gandit-o este asfel:
- clasa Marketplace, care are un nume, o lista de clienti si o lista de produse, careia ii este atribuita si o clasa de serviciu (MarketplaceService) ce se ocupa de operatiile cu *heavy-data* precum :
  - displayAll()
  - displayAllSortedByName()
  - displayAllSortedByNumberOfCustomers()
  - displayCustomersPerMarketplace()
- clasa Customer, care are un id, un nume, un cos *unic* si o lista de comenzi
- clasa Product, care are un id, un nume si un pret
- clasa ProductWithQuantity, din care se mostenesc CartProduct si OrderProduct (am ales aceste doua clase, intrucat, de exemplu, un produs poate sa-si modifice pretul in timp, insa ne dorim ca in *istoricul* comenzii unui client, acesta sa vada datele de la momentul respectiv)
- clasa Cart, in care tinem o lista de CartProduct si un total
- clasa Order, in care tinem o liste de OrderProduct, un OrderStatus si un total
- Clasa OrderStatus, care contine un Array de statusuri, care este atasat fiecarei comenzi pentru a sti starea curenta (se pot adauga in functie de necesitate si alte statusuri)

Pentru o logica desfasurare a comenzilor, se creeaza entitatile, fiecare client isi adauga produse in cos in functie de cantitate *addToCart()* si plaseaza comenzi *toOrder()*. Ordinea explicata mai devreme se poate regasi si in clasa Main.
