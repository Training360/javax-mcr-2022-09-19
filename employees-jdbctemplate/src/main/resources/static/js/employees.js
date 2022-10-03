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
            .then(handleResponse)
            .then(handleCreated)
            .catch(handleError);
    }
}

function handleResponse(response) {
    if (response.ok) {
        return response.json();
    }
    const error = Error();
    Object.assign(error, {response: response});
    throw error;   
    // throw new ValidationError("Invalid employee", response);
}

function handleError(error) {
    error.response.json().then(data => printError(data));
}

function printError(data) {
    const message = document.querySelector("#message");
    message.innerHTML = ""
    for (const violation of data.violations) {
        message.innerHTML += `<p>${violation.message}</p>`;
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
    document.querySelector("#message").innerHTML = `Employee has created with id ${data.id}`;
    fetchEmployees();
}

// class ValidationError extends Error {

//     constructor(message, response) {
//         super(message);
//         this.name = "ValidationError";
//         this.response = response;
//     }
// }