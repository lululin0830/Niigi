
const init = function () {

    console.log("進來了");

    fetch('http://localhost:8080/Niigi/SubOrderDetail', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            searchway: document.getElementById("SearchSelect").value
        })
    })
    console.log(document.getElementById("SearchSelect").value)

}
console.log("讀到了")
document.getElementById("search").addEventListener("click", init);