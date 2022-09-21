window.onload = function() {
    console.log("Starting employees frontend");
    fetch("http://localhost:8080/api/employees")
        .then(response => response.json())
        .then(employees => printEmployees(employees));
}

function printEmployees(employees) {
    tbody = document.querySelector("tbody");
    for (employee of employees) {
        row = `<tr><td>${employee.id}</td><td>${employee.name}</td></tr>`
        tbody.innerHTML += row
    }
}