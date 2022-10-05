# Vizsga - ToDo lista API

A feladatok megoldásához az IDEA fejlesztőeszközt használd!
A megoldáshoz bármit használhatsz.

## Alkalmazás

Hozz létre egy alkalmazást, amivel felhasználókat és elvégzendő tevékenységeket (ToDo) lehet adminisztrálni. 

## Nem-funkcionális követelmények

Klasszikus háromrétegű alkalmazás, MariaDB adatbázissal, Java Spring backenddel, REST webszolgáltatásokkal.

Követelmények tételesen:

* SQL adatbázis kezelő réteg megvalósítása Spring Data JPA-val (`Repository`)
* Liquibase
* Üzleti logika réteg megvalósítása `@Service` osztályokkal
* Controller réteg megvalósítása, RESTful API implementálására.
* Hibakezelés, validáció
* Hozz létre egy `Dockerfile`-t!
* Tesztesetek (legalább egy unit és egy integrációs teszt)


## Általános követelmények (12 pont)

- Alkalmazás szerkezeti felépítése, következetes mappa és package szerkezet - 2 pont
- A három réteg létrehozása megfelelő, indítható, működő Spring Boot alkalmazás - 3 pont
- Dockerfile és migrációs fájlok megléte, helyessége - 2 pont
- Clean code - 5 pont


## Az adatbázisréteg elkészítése  (12 pont)

A feladatban két entitást kell elkészítened, egyiket `User` a másikat `ToDo` néven. Fontos, hogy egy felhasználónak
több tevékenysége is lehet, de egy tevékenység csak egy felhasználóhoz tartozhat. A kapcsolat kétirányú legyen! <br>

User adatai:

* id (Long)
* userEmail (String)

ToDo adatai:

* description (Long)
* deadline (LocalDate - határidő)
* importance (Importance enum: URGENT, IMPORTANT, NON_URGENT; az elvégzendő tevékenység fontosságát jelöli)
* status (Status enum: DONE, WORKING_ON_IT, NOT_STARTED)

Adatbázist indíthatsz a következő Docker paranccsal:

```shell
docker run -d -e MYSQL_DATABASE=todolist -e MYSQL_USER=todo -e MYSQL_PASSWORD=todo -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -p 3306:3306 --name todolist-mariadb mariadb
```

### Részpontszámok

- Az entitások létrehozása helyes, `JPA` szabványnak megfelelő - 8 pont
- Tábla és oszlopnevek megfelelők - 4 pont

## Felhasználó és tevékenység mentése (28 pont)

### `POST /api/users`

A HTTP kérés törzsében egy felhasználó email címét várjuk. Az azonosítót az adatbázis osztja ki, míg a todo lista
kezdetben üres.<br>
Validálás:

- Az e-mail cím email formátumú kell, hogy legyen

A kérésben beérkező adatokat a fenti feltételek alapján validáld le, és hiba esetén küldj vissza hibaüzenetet, valamint 400-as hibakódot!

Sikeres mentés esetén küldd vissza az elmentett felhasználó összes adatát (id-val és todo listával együtt, figyelj rá, hogy a todo-nál ne szerepeljen még egyszer a user), és 201-es
kódot!

### Részpontok

* A beérkező HTTP kérést az alkalmazás kezeli (controller) - 3 pont
* Az adatok elmentésre kerülnek - 3 pont
* Validálás és hibakezelés - 3 pont
* A válasz tartalmazza a megfelelő adatokat - 3 pont

### `POST api/users/{id}/todos`

A user azonosítója az URL-ben érkezik.

A HTTP kérés törzse:

- leírás (nem lehet üres)
- határidő (Csak jövőbeli dátumot tartalmazhat)
- fontosság

A státusz a todo létrehozásának pillanatában mindig `NOT_STARTED`

A kérésben beérkező adatokat a fenti feltételek alapján validáld le, és hiba esetén küldj vissza hibaüzenetet, valamint 400-as hibakódot!

Ha nem megfelelő a felhaszáló azonosítója, 404-es státuszkóddal térj vissza és megfelelő hibaüzenettel.

Sikeres mentés esetén küldd vissza a todo adatait, és 201-es státuszkódot!

### Részpontok

* A beérkező HTTP kérést az alkalmazás kezeli - 3 pont
* Az adatok elmentésre kerülnek, ha megfelelők - 3 pont
* Egyszerű mezők validálása és hibakezelése - 3 pont
* Nem létező felhasználó hibájának kezelése - 3 pont
* A válasz tartalmazza a megfelelő adatokat - 3 pont

## ToDo frissítése (12 pont) (Elvégzése opcionális!!!)

### `PUT /api/todos/{id}`

Egy tevékenység sátusza frissíthető a végponton.

A kérés törzsében egy státuszt kapunk és az aktuális tevékenység státuszát frissítjük a kapottra.

Ha az id, nem megfelelő térjünk vissza 404-es státuszkóddal és hibaüzenettel.

A válasz törzsében a ToDo adatait küldjük vissza!

### Részpontok

- A beérkező HTTP kérést az alkalmazás kezeli - 3 pont
- Megfelelő hibakezelés - 4 pont
- Frissítés megvalósul - 3 pont
- A válasz tartalmazza a megfelelő adatokat - 2 pont

## ToDo-k lekérdezése (16 pont)

### `GET /api/users/{id}/todos`

Lehessen az összes ToDo-t lekérdezni a végponton.
Opcionálisan query stringként lehessen megadni státuszt ekkor csak az aktuális státusszal rendelkező ToDo-kat kérdezzük le, szintén fontossági sorrendben. (Elvégzése opcionális!!!)

Ha nem megfelelő a felhasználó azonosítója, 404-es státuszkóddal térj vissza és megfelelő hibaüzenettel.

Figyeljünk arra, hogy lehet, hogy a felhasználó létezik, csak nincsenek teendői, vagy egy adott státuszban nincs teendő. Ekkor
üres listával térj vissza!

Sikeres keresés esetén ToDo-k listájával térj vissza!

### Részpontok

* A beérkező HTTP kérést az alkalmazás kezeli (controller) - 3 pont
* Nem létező user hibájának kezelése - 3 pont
* Query paraméter nélkül az összes todo lekérdezésre kerül - 4 pont
* A query paraméter esetén megfelelő szűrés történik - 3 pont
* A válasz tartalmazza a megfelelő adatokat - 3 pont