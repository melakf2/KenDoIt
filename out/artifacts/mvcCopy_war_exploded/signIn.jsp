<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
    <title>ToDoList</title>
</head>
<body>
<div data-role="page"  id="signInPage">
    <div data-role="header" data-theme="b">
        <form action="Router"  method="post">
            <button  data-role="button" data-icon="home" data-iconpos="left">back</button>
            <input id="back" type="hidden" name="page" value="main">

        </form>
        <h1>Just Do It</h1>
    </div>

    <form id="Router" action="Router" method="post">
        <div role="main" class="ui-content">
            <h3>Sign In</h3>
            <label for="txt-email">Email Address</label>
            <input type="text" name="txt-email" id="txt-email" value="">
            <label for="txt-password">Password</label>
            <input type="password" name="txt-password" id="txt-password" value="">
            <!--<fieldset data-role="controlgroup">-->
            <!--<input type="checkbox" name="chck-rememberme" id="chck-rememberme" checked="">-->
            <!--<label for="chck-rememberme">Remember me</label>-->
            <!--</fieldset>-->
            <button type="submit"  data-rel="popup" data-transition="pop"  onsubmit="return true;"  data-position-to="window" id="btn-submit" class="ui-btn ui-btn-b ui-corner-all mc-top-margin-1-5">Submit</button>
            <p class="mc-top-margin-1-5"><a href="begin-password-reset.html">Can't access your account?</a></p>
            <div data-role="popup" id="dlg-invalid-credentials" data-dismissible="false" style="max-width:400px;">
                <div role="main" class="ui-content">
                    <h3 class="mc-text-danger">Login Failed</h3>
                    <p>Did you enter the right credentials?</p>
                    <div class="mc-text-center"><a href="#" data-rel="back" class="ui-btn ui-corner-all ui-shadow ui-btn-b mc-top-margin-1-5">OK</a></div>
                </div>
            </div>
            <input id="dataPage" type="hidden" name="page" value="signIn">
        </div><!-- /content -->
    </form>
    <div data-role="footer" data-theme="b">
        <h6 class="mc-text-center">Copyleft Sanad & Melak <span style="display:inline-block;
  transform: rotate(180deg);" class="copyleft">&copy;</span> 2017</h6>
    </div>
</div><!-- /page -->

<script type="text/javascript">
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
