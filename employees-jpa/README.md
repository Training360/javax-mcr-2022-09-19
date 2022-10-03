# Spring Boot oktatás

Virtuális gépeken Docker indításának előfeltétele:

```shell
net localgroup docker-users %USERDOMAIN%\%USERNAME% /add
```

Szükség van egy kijelentkezésre, majd Docker Desktop elindítása.

```shell
docker build -t employees .
docker run -d -p 8081:8080 --name my-employees employees
docker logs -f my-employees
```

```shell
docker build -t employees -f Dockerfile.layers .
```

```javascript
pm.test("The name is Jack Doe", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.name).to.eql("Jack Doe");
});
```

```shell
docker run -d -p 3306:3306 -e MARIADB_DATABASE=employees -e MARIADB_USER=employees -e MARIADB_PASSWORD=employees -e MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=yes --name my-mariadb mariadb 
```