
function decrementAwayScore()
{   
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)      
        {
            var score = xmlhttp.responseText + "<br/>" + "Away";
            document.getElementById("awayScore").innerHTML = score;
                        
            updateLog(xmlhttp);
        }
    }
    var url = "../game/away/decrement";
    sendRequest(xmlhttp, url);
}

function decrementHomeScore()
{   
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)      
        {
            var score = xmlhttp.responseText + "<br/>" + "Home";
            document.getElementById("homeScore").innerHTML = score;
                        
            updateLog(xmlhttp);
        }
    }
    var url = "../game/home/decrement";
    sendRequest(xmlhttp, url);
}

function incrementAwayScore()
{   
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)      
        {
            var score = xmlhttp.responseText + "<br/>" + "Away";
            document.getElementById("awayScore").innerHTML = score;
                        
            updateLog(xmlhttp);
        }
    }
    var url = "../game/away/increment";
    sendRequest(xmlhttp, url);
}

function incrementHomeScore()
{   
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange=function(whw)
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)      
        {
            var score = xmlhttp.responseText + "<br/>" + "Home";
            document.getElementById("homeScore").innerHTML = score;
                        
            updateLog(xmlhttp);
        }
    }
    var url = "../game/home/increment";
    sendRequest(xmlhttp, url);
}

function sendRequest(xmlhttp, url)
{
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("p1=a&p2=b");    
}

function updateLog(xmlhttp)
{
    var logEntry = xmlhttp.responseText + "<br/>" + document.getElementById("logs").innerHTML;
    
    document.getElementById("logs").innerHTML = logEntry;
}
