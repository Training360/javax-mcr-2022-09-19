window.onload = function() {
    console.log("Starting employees frontend");

    fetchEmployees();
    const button = document.querySelector("button");
    button.onclick =  function() {
        console.log("Clicked")
        const name = document.querySelector("#name").value;
        const yearOfBirth = Number(document.querySelector("#yearOfBirth").value);
        const data = {"name": name, "yearOfBirth": yearOfBirth}
        console.log(data);

        fetch("http://localhost:8080/api/employees", 
                {method: 'POST', 
                headers: {"Content-Type": "application/json"},  
                body: JSON.stringify(data)})
            .then(response => response.json())
            .then(data => handleCreated(data));
    }
}

function fetchEmployees() {
    fetch("http://localhost:8080/api/employees")
        .then(response => response.json())
        .then(employees => printEmployees(employees));
}

function printEmployees(employees) {
    tbody = document.querySelector("tbody");
    tbody.innerHTML = "";
    for (const employee of employees) {
        row = `<tr><td>${employee.id}</td><td>${employee.name}</td></tr>`;
        tbody.innerHTML += row;
    }
}

function handleCreated(data) {
    console.log(data);
    fetchEmployees();
}