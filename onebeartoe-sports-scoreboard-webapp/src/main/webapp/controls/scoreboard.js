


function incrementHomeScore()
{
//    alert('hi from time lapse state change');
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)      
        {
            var s = xmlhttp.responseText + "<br/>" + document.getElementById("logs").innerHTML;
            document.getElementById("logs").innerHTML = s;
        }
    }
    var url = "../game/home/increment";
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("p1=a&p2=b");
}