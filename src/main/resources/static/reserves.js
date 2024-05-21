// add movie details form
// be sure that the ids of the input elements in the html is the same used here
function addReserve() {
    const startDate = document.getElementById('startDate').value;
    const endDate = document.getElementById('endDate').value;
    const clientName = document.getElementById('clientName').value;
    const clientSurname = document.getElementById('clientSurname').value;

    // create the object that is defined in your model, use the correct properties
    const reserve = {
        startDate: startDate,
        endDate: endDate,
        client: {
            name: clientName,
            surname: clientSurname
        }
    };

    // this route will send the request to the endpoint under "@PostMapping("/add")", modify it if needed
    fetch('/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reserve)
    }).then(response => {
        // if the response is ok reload the page to get the new elements
        // if not, show an alert with the error
        if (response.ok) {
            window.location.href = "/";
        } else {
            return response.text().then(text => {
                alert("Error: " + text);
            });
        }
    }).catch(error => {
        alert("Error: " + error);
    });
}

document.addEventListener("DOMContentLoaded", function () {
    // add movie details form
    // be sure that the id in the html element is the same that is used here
    document.getElementById('addReserveButton').addEventListener('click', function (event) {
        event.preventDefault();
        addReserve();
    });
});