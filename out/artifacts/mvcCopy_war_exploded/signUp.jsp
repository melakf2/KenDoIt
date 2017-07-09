
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <!--<link rel="stylesheet" href="com.msn.justdoit/resources/jquery.mobile-1.4.5.css">-->
    <!--<link href="src/com.msn.justdoit/resources/css/app.css" rel="stylesheet" />-->
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <title>ToDoList</title>
</head>
<body>
<div data-role="page" id="signUpPage">
    <div data-role="header" data-theme="b">
        <form action="Router" method="post">
            <button data-role="button" data-icon="home" data-iconpos="left">back</button>
            <input id="back" type="hidden" name="page" value="main">
        </form>
        <h1>Just Do It</h1>
    <form id="Router" action="Router" method="post">
        <div role="main" class="ui-content">
            <h3>Sign Up</h3>
            <label for="txt-first-name">First Name</label>
            <input type="text" name="txt-first-name" id="txt-first-name" value="">
            <label for="txt-last-name">Last Name</label>
            <input type="text" name="txt-last-name" id="txt-last-name" value="">
            <label for="txt-email">Email Address</label>
            <input type="email" name="txt-email" id="txt-email" value="">
            <label for="txt-password">Password</label>
            <input type="password" name="txt-password" id="txt-password" value="">
            <label for="txt-password-confirm">Confirm Password</label>
            <input type="password" name="txt-password-confirm" id="txt-password-confirm" value="">
            <button type="submit"  data-rel="popup" data-transition="pop" data-position-to="window" id="btn-submit" class="ui-btn ui-btn-b ui-corner-all mc-top-margin-1-5">Submit</button>
            <div data-role="popup" id="dlg-sign-up-sent" data-dismissible="false" style="max-width:400px;">
                <div data-role="header">
                    <h1>Almost done...</h1>
                </div>
                <div role="main" class="ui-content">
                    <h3>congratulations you have successfully registered</h3>
                    <p>Let's go and create a Weekly Attack Plan.</p>
                    <div class="mc-text-center"><a href="sign-in.html" class="ui-btn ui-corner-all ui-shadow ui-btn-b mc-top-margin-1-5">OK</a></div>
                </div>
            </div>
        </div><!-- /content -->
        <input id="dataPage" type="hidden" name="page" value="signUp">
    </form>

    <div data-role="footer" data-theme="b">
        <h6 class="mc-text-center">Copyleft Sanad & Melak <span style="display:inline-block;
  transform: rotate(180deg);" class="copyleft">&copy;</span> 2017</h6>
    </div>
    <%
        String alert = (String)request.getAttribute("error");
    %>
</div><!-- /page -->
<script type="text/javascript">
    var alert=<%=alert%>;
    if(alert=="true"){
        $("#dlg-sign-up-sen").pop();
    }
    $(document).on("pagecreate","#signUpPage", function(){
        console.log("111  ============================>");
        $("#btn-submit").on("click", function(){
            var firstName=$("#txt-first-name").value;
            var lastName=$("#txt-last-name").value;
            var email=$("#txt-email").value;
            var password=$("#txt-password").value;
            var passwordConfirm=$("#txt-password-confirm").value;
            var testEmail = /^[A-Z0-9._%+-]+@([A-Z0-9-]+\.)+[A-Z]{2,4}$/i;
            if (testEmail.test(email) && password===passwordConfirm)
            {
                console.log("222  ============================>");
                $("#dlg-sign-up-sent").popup("open");
                setTimeout(function(){  $("#p").popup("close"); }, 5000);
            }
        });
    });
    $(document).on('pagebeforeshow', function () {
        $('#button_logout').toggle();
    });
    $(document).on('click', '#button_login', function () {
        $('#button_logout').addClass('ui-btn-right').toggle();
        $(this).removeClass('ui-btn-right').toggle();
    });

    $(document).on('click', '#button_logout', function () {
        $('#button_login').addClass('ui-btn-right').toggle();
        $(this).removeClass('ui-btn-right').toggle();
    });


</script>
</body>

</html>
