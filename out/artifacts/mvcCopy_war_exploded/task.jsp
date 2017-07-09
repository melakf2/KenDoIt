<%@ page import="il.ac.hit.mvcdemo.model.Items" %>
<%@ page import="il.ac.hit.mvcdemo.model.HibernateToDoListDAO" %>
<%@ page import="il.ac.hit.mvcdemo.model.User" %>
<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="il.ac.hit.mvcdemo.model.Router" %><%--
  Created by IntelliJ IDEA.
  User: Sanad
  Date: 18/06/2017
  Time: 01:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <!-- <link href="css/themes/1/conf-room1.min.css" rel="stylesheet" />
    <link href="css/themes/1/jquery.mobile.icons.min.css" rel="stylesheet" />
    <link href="lib/jquery.mobile.structure-1.4.4.min.css.js" rel="stylesheet" />
    <link href="css/app.css" rel="stylesheet" />-->
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.4/jquery.mobile-1.4.4.min.css">
    <!--<script src="http://code.jquery.com/mobile/1.4.4/jquery.mobile-1.4.4.min.js"></script>-->
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.3/jquery.mobile-1.4.3.min.js"></script>
    <!--<script src="jquery-mobile-theme-224358-0/jquery-ui.1.11.4.min.js"></script>-->
</head>

<body>
<div data-role="page" id="myDIV">
    <div data-role="header" data-theme="b">

        <h1>Just Do It</h1>
        <form action="signIn.jsp">
            <button action="signIn" data-role="button" id="button_logout" data-icon="false" data-iconpos="false" class="ui-btn-right">logout</button>
        </form>

    </div><!-- /header -->
    <button id="myInput"   class="addBtn" onclick="openDialog()" >Add Item</button>
    <div id="task">
        <form action="Router" method="post" id="Rouer">
        <label for="itemName">Name</label>
        <input type="text" id="itemName" name="itemName" value="" placeholder="Task name...">
        <label for="description">Description</label>
        <input  id="description"  name="description" value="" cols="30" rows="10" placeholder="Add description..">
        <button type="submit" id="createTaskItem" name="actionTask" value="addTask" class="addBtn">Create</button>
            <input id="dataPage" type="hidden" name="page" value="task">
        </form>
    </div>

    <ul id="myUL" data-role="listview" data-theme="a" data-filter="true">
    <%
        HibernateToDoListDAO htdl = HibernateToDoListDAO.getInstance();
        User currentUser = Router.getCurrentUser();
        Items [] items=htdl.getItems(currentUser);
        for(int i=0; i<items.length; i++)
        {
    %>
    <li data-role="collapsible">
        <h1><%= (String)items[i].getDescription() %></h1>
        <p><%= (String)items[i].getItemName() %></p>
    </li>
    <%
        }
    %>
    </ul>


    <%--<ul id="myUL" data-role="listview" data-theme="a" data-filter="true">--%>
        <%--<li data-role="collapsible">--%>

            <%--<h1>Hit gym</h1>--%>
            <%--<p>bla bal bla .</p>--%>

        <%--</li>--%>
        <%--<li data-role="collapsible">--%>
            <%--<h1>Hit gym</h1>--%>
            <%--<p>bla bal bla .</p>--%>
        <%--</li>--%>
    <%--</ul>--%>
    <div data-role="footer" data-theme="b">
        <h6 class="mc-text-center">Copyleft Sanad & Melak <span style="display:inline-block;
  transform: rotate(180deg);" class="copyleft">&copy;</span> 2017</h6>
    </div>

</div>
<!--<div id="myDIV" class="header">
    <h2>My To Do List</h2>
    <input type="text" id="myInput" placeholder="Title...">
    <span onclick="newElement()" class="addBtn">Add</span>
</div>-->

<script>
    // Create a "close" button and append it to each list item
    $( document ).ready(function() {
        $("#task").hide();
        var k=0;
        $(".page").each(function (i,obj) {
            console.debug("i = "+i);
            if(i!=0){
                this.style.display="none";
            }
        });
    });

    document.querySelector('#createTaskItem').addEventListener('click', function() {
        $("#task").fadeOut(2000);
        var inputValue = document.getElementById("itemName").value;
        var itemValue = document.createTextNode(inputValue);
        var desValue = document.getElementById("description").value;
        var descValue = document.createTextNode(desValue);

        var list = document.getElementById('myUL');
        var li = document.createElement("li");
        li.setAttribute("data-role","collapsible");
        li.className="ui-collapsible member-item ui-collapsible-inset ui-corner-all ui-collapsible-themed-content ui-collapsible-collapsed ui-li-static ui-body-inherit ui-first-child";
        li.setAttribute("href","#");
        console.log(li);
        var titleTask =document.createElement("H1");
        titleTask.className="ui-collapsible-heading ui-collapsible-heading-collapsed";

        var link=document.createElement("a");
        link.setAttribute("href","#");
        link.className="ui-collapsible-heading-toggle ui-btn ui-icon-plus ui-btn-icon-left ui-btn-inherit";
        link.innerText=inputValue;

        var spanTitle=document.createElement("SPAN");
        spanTitle.className="ui-collapsible-heading-status";
        spanTitle.innerText=" click to expand contents";
        var divContent=document.createElement("DIV");
        divContent.className="ui-collapsible-content ui-body-inherit ui-collapsible-content-collapsed";
        divContent.setAttribute("aria-hidden","true");
        var textArea= document.createElement("P");
        textArea.innerHTML=desValue;
        divContent.appendChild(textArea);
        var txt = document.createTextNode("\u00D7");
        var spanClose=document.createElement("SPAN");
        spanClose.className="close";
        spanClose.innerText=txt;
        link.appendChild(spanTitle);
        titleTask.appendChild(link);
        li.append(titleTask);
        li.appendChild(divContent);

        //if the task name or description is empty
        if (inputValue === '') {
            alert("You must write something!");
        } else if (desValue === ''){
            alert("You must write description!");
        } else { //add the task with its description to the list items
            list.appendChild(li);
            document.getElementById("itemName").innerText = "";
            document.getElementById("description").innerHTML= "";

            var span = document.createElement("SPAN");
            span.className = "close";
            span.appendChild(txt);
            li.appendChild(span);
            for (i = 0; i < close.length; i++) {
                close[i].onclick = function () {
                    var div = this.parentElement;
                    div.style.display = "none";
                }
            }
        }
    });

    document.querySelector('body').addEventListener('click', function(event) {
        if (event.target.tagName.toLowerCase() === 'a') {
            toggle(event.target);
        }
    });
    function toggle( Link) {
        console.log("HIIII==========>>>>>>>");
        var listItem=Link.parentNode.parentNode;
        var className=listItem.className;
        var header= listItem.childNodes[0];
        var linker=header.childNodes[0];
        var div=header.nextSibling;
        //if the plus button is not clicked
        if(className.indexOf("ui-collapsible-collapsed")>0){
            console.log("collapse");
            listItem.className="ui-collapsible ui-collapsible-inset ui-corner-all ui-collapsible-themed-content ui-li-static ui-body-inherit ui-last-child";
            header.className="ui-collapsible-heading";
            linker.className="ui-collapsible-heading-toggle ui-btn ui-btn-icon-left ui-btn-inherit ui-icon-minus";
            linker.childNodes[0].innerText="click to collapse contents";
            div.className="ui-collapsible-content ui-body-inherit";
            div.setAttribute("aria-hidden",false);
        }
        else //the plus button clicked and now its a minus button
        {
            console.log("expand");
            listItem.className="ui-collapsible ui-collapsible-inset ui-corner-all ui-collapsible-themed-content ui-li-static ui-body-inherit ui-last-child ui-collapsible-collapsed";
            header.className="ui-collapsible-heading ui-collapsible-heading-collapsed";
            linker.className="ui-collapsible-heading-toggle ui-btn ui-btn-icon-left ui-btn-inherit ui-icon-plus";
            linker.childNodes[0].innerText="click to expand contents";
            div.className="ui-collapsible-content ui-body-inherit ui-collapsible-content-collapsed";
            div.setAttribute("aria-hidden",true);
        }

    }

    function openDialog() {
        var form=$("#task").fadeIn(2000);
    }

    //the 'x' button to delete a specific item
    var myNodelist = document.getElementsByTagName("LI");
    var i;
    for (i = 0; i < myNodelist.length; i++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span);
    }

    // Click on a close button to hide the current list item
    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }

    // Add a "collapse"  when clicking on a list item

    // Add a "checked" symbol when clicking on a list item
    var list = document.querySelector('ul');
    list.addEventListener('click', function(ev) {
        if (ev.target.tagName === 'LI') {
            // ev.target.classList.toggle('checked');
        }
    }, false);

    // Create a new list item when clicking on the "Add" button
    function newElement() {
        $("#task").fadeOut(2000);
        var inputValue = document.getElementById("itemName").value;
        var itemValue = document.createTextNode(inputValue);
        var desValue = document.getElementById("description").value;
        var descValue = document.createTextNode(desValue);
        var list = document.getElementById('myUL');
        var li = document.createElement("li");
        li.setAttribute("data-role","collapsible");
        li.className="ui-collapsible member-item ui-collapsible-inset ui-corner-all ui-collapsible-themed-content ui-collapsible-collapsed ui-li-static ui-body-inherit ui-first-child";
        li.setAttribute("href","#");
        console.log(li);
        var titleTask =document.createElement("H1");
        titleTask.className="ui-collapsible-heading ui-collapsible-heading-collapsed";

        var link=document.createElement("a");
        link.setAttribute("href","#");
        link.className="ui-collapsible-heading-toggle ui-btn ui-icon-plus ui-btn-icon-left ui-btn-inherit";
        link.innerText=inputValue;

        var spanTitle=document.createElement("SPAN");
        spanTitle.className="ui-collapsible-heading-status";
        spanTitle.innerText=" click to expand contents";
        var divContent=document.createElement("DIV");
        divContent.className="ui-collapsible-content ui-body-inherit ui-collapsible-content-collapsed";
        divContent.setAttribute("aria-hidden","true");
        var textArea= document.createElement("P");
        textArea.innerHTML=desValue;
        divContent.appendChild(textArea);
        var txt = document.createTextNode("\u00D7");
        var spanClose=document.createElement("SPAN");
        spanClose.className="close";
        spanClose.innerText=txt;
        link.appendChild(spanTitle);
        titleTask.appendChild(link);
        li.append(titleTask);
        li.appendChild(divContent);


        if (inputValue === '') {
            alert("You must write something!");
        } else if (desValue === ''){
            alert("You must write description!");
        } else {
            list.appendChild(li);
            document.getElementById("itemName").value = "";
            document.getElementById("description").value = "";

            var span = document.createElement("SPAN");
            span.className = "close";
            span.appendChild(txt);
            li.appendChild(span);
            for (i = 0; i < close.length; i++) {
                close[i].onclick = function () {
                    var div = this.parentElement;
                    div.style.display = "none";
                }
            }
//           // $('#myUL').trigger('create');
//            $('#myUL').listview("refresh");
//           // $('#myUL').listview.refresh();
//            $('.member-item').collapsible('refresh');
        }
    }
</script>
</body>

</html>
