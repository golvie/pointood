var req;

function select_product(prod_id)
{
show_form();
get_product(prod_id);
}
function show_form()
{	
	if (document.layers) document.layers["response"].visibility="show";
	else document.getElementById("response").style.visibility="visible";
}
function get_product(prod_id)
{
	GetXmlHttpObject(); 

var url="c?mode=ordersearch&orderId="+prod_id;
url = encodeURI(url);

	if(req!=null)
	{
	    req.onreadystatechange = Process_request;
	    req.open("GET", url, true);
	    req.send(null);
	
	}
}
function GetXmlHttpObject()
{
    try
    {
        req=new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch(e)
    {
        try
        {
            req=new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch(oc)
        {
            req=null;
        }
    }

    if(!req&&typeof XMLHttpRequest!="undefined")
    {
        req = new XMLHttpRequest();
	}
} 
function Process_request()
{
    if (req.readyState == 4)
        {
    	if (req.status == 200)
            {
                if(req.responseText!="")
                {   
                	document.getElementById("response").innerHTML=req.responseText;
  
                }
            }
            else
            {
            	document.getElementById("response").innerHTML=
                    "Probleem andmete saamisega:<br>"+req.statusText;
            }
        }
}