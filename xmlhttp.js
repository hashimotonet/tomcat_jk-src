function loadTextFile()
{
httpObj = createXMLHttpRequest(displayData);
if (httpObj)
{
httpObj.open("GET","data.txt",true);
httpObj.send(null);
}
}
function displayData()
{
if ((httpObj.readyState == 4) && (httpObj.status == 200))
{
document.ajaxForm.result.value = httpObj.responseText;
}
}
// HTTPí êMópÅAã§í ä÷êî
function createXMLHttpRequest(cbFunc)
{
var XMLhttpObject = null;
try{
XMLhttpObject = new XMLHttpRequest();
}catch(e){
try{
XMLhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
}catch(e){
try{
XMLhttpObject = new ActiveXObject("Microsoft.XMLHTTP");
}catch(e){
return null;
}
}
}
if (XMLhttpObject) XMLhttpObject.onreadystatechange = cbFunc;
return XMLhttpObject;
}
