
const init = function () {

    console.log("進來了");

    const data = JSON.stringify({
        searchcase: document.getElementById("Searchcase").value,
        searchway: document.getElementById("SearchSelect").value,
        StartDate: document.getElementById("StartDate").value,
        EndDate: document.getElementById("EndDate").value,
        DateSelect: document.getElementById("DateSelect").value
    })

    fetch('http://localhost:8080/Niigi/SubOrderDetail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: data
    }).then(r => r.json()).then(data => {

    })
    console.log(data)



}
console.log("讀到了")
document.getElementById("search").addEventListener("click", init);