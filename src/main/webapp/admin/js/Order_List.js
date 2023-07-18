
const init = function () {

    console.log("進來了");

    const searchdata = JSON.stringify({
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
        body: searchdata
    }).then(r => r.json()).then(data => {
        const tbody = document.querySelector('#searchResult');
        tbody.innerHTML = "";
        data.forEach(element => {

            const row = `<tr>
                <td> ${element[0].subOrderId}</td>
                <td> ${element[0].memberId}</td>
                <td> ${element[0].supplierId}</td>
                <td> ${element[0].subOrderId}</td>
                <td> ${element[1].productId}</td>
                <td>1</td>
                <td> ${element[1].productPrice}</td>
                <td> ${element[0].orderCreateTime}</td>
                <td> ${element[0].orderCloseTime}</td>
                <td> ${element[0].grossProfit}</td>
                    </tr>`;
            let rowData = "<tr>"

            tbody.innerHTML += row;

            console.log(data)
        });

    })




}
console.log("讀到了")
document.getElementById("search").addEventListener("click", init);


