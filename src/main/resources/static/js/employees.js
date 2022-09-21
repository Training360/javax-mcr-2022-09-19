window.onload = function() {
    console.log("Starting employees frontend");
    fetch("http://localhost:8080/api/employees")
        .then(response => response.json())
        .then(employees => printEmployees(employees));

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
            .then(data => console.log(data));
    }
}

function printEmployees(employees) {
    tbody = document.querySelector("tbody");
    for (const employee of employees) {
        row = `<tr><td>${employee.id}</td><td>${employee.name}</td></tr>`;
        tbody.innerHTML += row;
    }
}