var fileContent;
var globalStr;


function onPageLoad()
{
    globalStr = Android.onPageLoad();
//    document.write("<h1>" + globalStr + "</h1>")
    document.getElementById("one").innerHTML = Android.toString();

}

function readFileContent()
{

    fileContent = Android.readFile();
    showToast(fileContent);
    document.getElementById("commontext").innerHTML=fileContent;
}

function showToast(toast) {
    Android.showToast(toast);
//    alert(toast)
}

function makeOption(){

}

function show1() {
    var value = Android.toString();
    showToast(value);
    document.getElementById("show1").innerHTML = value;
}
