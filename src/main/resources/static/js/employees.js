window.onload = function() {
    console.log("Starting employees frontend");
    fetch("http://localhost:8080/api/employees")
        .then(response => response.json())
        .then(employees => console.log(employees));
}