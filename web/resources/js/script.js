function showMessage(messageHTML, element) {
    document.getElementById(element).innerHTML = messageHTML;
}

let canvas = document.querySelector("#shapesCanvas");
let c = canvas.getContext("2d");
canvas.width = 400;
canvas.height = 400;
//let radius = 160;
let width = 400;
let height = 400;
let stockRadius = 160;
c.strokeStyle = "#FFFFFF";

function drawGraph(radius) {
// x-line
    c.beginPath();
    c.moveTo(5, height/2);
    c.lineTo(width-5, height/2);
    c.moveTo(width/2-stockRadius, height/2-3);
    c.lineTo(width/2-stockRadius, height/2+3);
    c.moveTo(width/2-stockRadius/2, height/2-3);
    c.lineTo(width/2-stockRadius/2, height/2+3);
    c.moveTo(width/2+stockRadius/2, height/2-3);
    c.lineTo(width/2+stockRadius/2, height/2+3);
    c.moveTo(width/2+stockRadius, height/2-3);
    c.lineTo(width/2+stockRadius, height/2+3);
    c.moveTo(width-10, height/2-5);
    c.lineTo(width-6, height/2);
    c.lineTo(width-10, height/2+5);
    c.stroke();

//y-line
    c.beginPath();
    c.moveTo(width/2, 5);
    c.lineTo(width/2, height-5);
    c.moveTo(width/2-3, height/2-stockRadius);
    c.lineTo(width/2+3, height/2-stockRadius);
    c.moveTo(width/2-3, height/2-stockRadius/2);
    c.lineTo(width/2+3, height/2-stockRadius/2);
    c.moveTo(width/2-3, height/2+stockRadius/2);
    c.lineTo(width/2+3, height/2+stockRadius/2);
    c.moveTo(width/2-3, height/2+stockRadius);
    c.lineTo(width/2+3, height/2+stockRadius);
    c.moveTo(width/2-5, 10);
    c.lineTo(width/2, 6);
    c.lineTo(width/2+5, 10);
    c.stroke();

//text
    c.font = "14px Arial";
    c.fillStyle = "#FFFFFF";
    c.fillText("X", width-13, height/2 -5);
    c.fillText(radius + '/2', width/2 + stockRadius/2, height/2-5);
    c.fillText(radius, width/2 + stockRadius, height/2-5);
    c.fillText('-' + radius, width/2 - stockRadius, height/2-5);
    c.fillText('-' + radius + '/2', width/2 - stockRadius/2, height/2-5);
    c.fillText("Y", width/2+5, 13);
    c.fillText('-' + radius, width/2+5, height/2 + stockRadius);
    c.fillText('-' + radius + '/2', width/2+5, height/2 + stockRadius/2);
    c.fillText(radius + '/2', width/2+5, height/2 - stockRadius/2);
    c.fillText(radius, width/2+5, height/2 - stockRadius);

}


function drawFigures(radius) {
    let shiftRadius = radius*stockRadius/1.5;
    drawGraph(radius);
// 1part
    c.fillStyle = "rgb(255,255,255,0.4)";
    c.fillRect(width / 2, height / 2 - shiftRadius / 2, shiftRadius, shiftRadius / 2);

// 2part circle of 3 part r= r/2
    c.beginPath();
    c.moveTo(width / 2 - shiftRadius, height / 2);
    c.lineTo(width / 2, height / 2);
    c.lineTo(width / 2, height / 2 - shiftRadius);
    c.arc(width / 2, height / 2, shiftRadius, Math.PI, Math.PI * 1.5);
    c.fill();

// 3part triangle 0 r/2 r/2
    c.beginPath();
    c.moveTo(width / 2, height / 2 + shiftRadius / 2);
    c.lineTo(width / 2 - shiftRadius / 2, height / 2);
    c.lineTo(width / 2, height / 2);
    c.lineTo(width / 2, height / 2 + shiftRadius / 2);
    c.fill();
}

function drawDot(x, y, hit) {
    c.fillStyle = hit ? "#009900" : "#990000";
    c.beginPath();
    c.arc(x, y, 1.5, 0, Math.PI * 2);
    c.fill();

}

function drawAllDots() {
    let dots = document.getElementById("tableData").querySelectorAll("*");
    for (let i = 0; i < dots.length; i++) {
        c.fillStyle = dots[i].getAttribute("isHit") ? "#009900" : "#990000";
        c.beginPath();
        c.arc(dots[i].getAttribute("xValue"),
            dots[i].getAttribute("yValue"),
            1.5, 0, Math.PI * 2);
        c.fill();
    }
}

function draw() {
    drawGraph(stockRadius);
    drawFigures(stockRadius);
    drawAllDots();
}


canvas.addEventListener("mousedown", function (event) {
    let click_x, click_y;
    let r = document.getElementById("rValue");
    let rect = canvas.getBoundingClientRect();
    click_x = event.clientX - rect.left;
    click_y = event.clientY - rect.top;
    let x = (click_x - 200) / 160 * r;
    let y = (-click_y + 200) / 160 * r;
    drawDot(click_x, click_y,);
    sendCanvas(x.toFixed(3), y.toFixed(3), r);
});

function sendCanvas(x, y) {
    document.getElementById("xHidden").value = x;
    document.getElementById("yHidden").value = y;
    document.getElementById("rRidden").value = r;
    let button = document.getElementById("submitButton1");
    button.click();
}
