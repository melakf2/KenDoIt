<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <title>Main Page</title>
</head>
<body>
<form name="landingPageForm"  action="Router" method="post">
<div data-role="page">
    <div data-role="header" data-theme="b">
        <h1>ToDoList</h1>
    </div><!-- /header -->
    <div role="main" class="ui-content">
        <p class="mc-top-margin-1-5"><b>Existing Users</b></p>
        <input type="button"  name="sign-in"  value="signIn" class="ui-btn ui-btn-b ui-corner-all"
               onclick="{document.landingPageForm.main.value=this.value;document.landingPageForm.submit();}">
        <p class="mc-top-margin-1-5"><b>Don't have an account?</b></p>
        <input type="button" name="sign-in" value="signUp" class="ui-btn ui-btn-b ui-corner-all"
               onclick="{document.landingPageForm.main.value=this.value;document.landingPageForm.submit();}">

        <br/>
        <input type="hidden" name="page" value="main" />
        <input type="hidden" name="main" value="" />
    </div><!-- /content -->
</div><!-- /page -->
</form>
</body>
</html>
