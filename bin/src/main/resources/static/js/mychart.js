let chartDataString = decodeHtml(chartData);
let chartJsonArray = JSON.parse(chartDataString);

let arrayLength = chartJsonArray.length;
let numericData = [];
let labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].stageStatus;
    labelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", ],
            data: numericData,
        }]
    },

    // Configuration options go here
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

// [{}, {}, {}]
function decodeHtml(html) {
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}