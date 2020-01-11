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
let stockRadius = 60;
c.strokeStyle = "#FFFFFF";

function drawGraph(radius) {
// x-line
    c.beginPath();
    c.moveTo(5, height/2);
    c.lineTo(width-5, height/2);
    c.moveTo(width/2-stockRadius, height/2-3);
    c.lineTo(width/2-stockRadius, height/2+3);
    c.moveTo(width/2-stockRadius*2, height/2-3);
    c.lineTo(width/2-stockRadius*2, height/2+3);
    c.moveTo(width/2+stockRadius*2, height/2-3);
    c.lineTo(width/2+stockRadius*2, height/2+3);
    c.moveTo(width/2+stockRadius, height/2-3);
    c.lineTo(width/2+stockRadius, height/2+3);
    c.moveTo(width-10, height/2-5);
    c.lineTo(width-6, height/2);
    c.lineTo(width-10, height/2+5);
    c.closePath();
    c.stroke();


//y-line
    c.beginPath();
    c.moveTo(width/2, 5);
    c.lineTo(width/2, height-5);
    c.moveTo(width/2-3, height/2-stockRadius);
    c.lineTo(width/2+3, height/2-stockRadius);
    c.moveTo(width/2-3, height/2-stockRadius*2);
    c.lineTo(width/2+3, height/2-stockRadius*2);
    c.moveTo(width/2-3, height/2+stockRadius*2);
    c.lineTo(width/2+3, height/2+stockRadius*2);
    c.moveTo(width/2-3, height/2+stockRadius);
    c.lineTo(width/2+3, height/2+stockRadius);
    c.moveTo(width/2-5, 10);
    c.lineTo(width/2, 6);
    c.lineTo(width/2+5, 10);
    c.closePath();
    c.stroke();

//text
    c.font = "14px Arial";
    c.fillStyle = "#FFFFFF";
    c.fillText("X", width-13, height/2 -5);
    c.fillText('2', width/2 + stockRadius*2, height/2-5);
    c.fillText('1', width/2 + stockRadius, height/2-5);
    c.fillText('-1', width/2 - stockRadius, height/2-5);
    c.fillText('-2', width/2 - stockRadius*2, height/2-5);
    c.fillText("Y", width/2+5, 13);
    c.fillText('-1', width/2+5, height/2 + stockRadius);
    c.fillText('-2', width/2+5, height/2 + stockRadius*2);
    c.fillText('2', width/2+5, height/2 - stockRadius*2);
    c.fillText("1", width/2+5, height/2 - stockRadius);

}


function drawFigures(radius) {
    let shiftRadius = radius*stockRadius;
// 1part
    c.fillStyle = "rgb(255,255,255,0.4)";
    c.fillRect(width / 2, height / 2 - shiftRadius / 2, shiftRadius, shiftRadius / 2);

// 2part circle of 3 part r= r/2
    c.beginPath();
    c.moveTo(width / 2 - shiftRadius, height / 2);
    c.lineTo(width / 2, height / 2);
    c.lineTo(width / 2, height / 2 - shiftRadius);
    c.arc(width / 2, height / 2, shiftRadius, Math.PI, Math.PI * 1.5);
    c.closePath();
    c.fill();

// 3part triangle 0 r/2 r/2
    c.beginPath();
    c.moveTo(width / 2, height / 2 + shiftRadius / 2);
    c.lineTo(width / 2 - shiftRadius / 2, height / 2);
    c.lineTo(width / 2, height / 2);
    c.lineTo(width / 2, height / 2 + shiftRadius / 2);
    c.closePath();
    c.fill();
    drawGraph(radius);
}
function drawDot(x, y, hit) {
    c.fillStyle = hit ? "#009900" : "#990000";
    c.beginPath();
    c.arc(x, y, 1.5, 0, Math.PI * 2);
    c.fill();

}

function drawAllDots(){
    let dots = document.getElementById("data").querySelectorAll("*");
    for (let i = 0; i < dots.length; i++) {
        let x = dots[i].getAttribute("data-x");
        let y = dots[i].getAttribute("data-y");
        let r = dots[i].getAttribute("data-r");
        let hit = checkArea(x,y,r);
        drawDot(x*stockRadius+200, 200-y*stockRadius, hit);
    }
}

//при клике обновляется все страница (мб надо чтобы это был аякс клик?) еще почему то все время последнее значение пересылается в бд значения
canvas.addEventListener("mousedown", function (event) {
    let click_x, click_y;
    let r = PF("rSelect").getSelectedValue();
    let rect = canvas.getBoundingClientRect();
    click_x = event.clientX - rect.left;
    click_y = event.clientY - rect.top;
    let x = (click_x - 200) / stockRadius;
    let y = (-click_y + 200) / stockRadius;
    drawDot(click_x, click_y, checkArea(x.toFixed(3), y.toFixed(3), r));

    document.getElementById("canvasForm:xHidden").value = x.toFixed(3);
    document.getElementById("canvasForm:yHidden").value = y.toFixed(3);
    document.getElementById("canvasForm:rHidden").value = r;
    let button = document.getElementById("canvasForm:submitButtonHidden");
    button.click();
});


function checkArea(xVal, yVal, rVal) {
    if(xVal>=0 && yVal>=0 && xVal<=rVal && yVal<=rVal/2) return true;
    if(xVal<=0 && yVal>=0 && rVal*rVal >= xVal*xVal+yVal*yVal)return true;
    if(xVal<=0 && yVal<=0 && yVal >= -xVal-rVal/2) return true;
    return false;
}
function drawCanvas(radius) {
    c.clearRect(0,0,width,height);
    drawAllDots();
    drawFigures(radius);
    drawAllDots(radius)
}
