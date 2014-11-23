<html>
    <head>
         <link rel="stylesheet" href="/assets/css/bootstrap.css">
         <link rel="stylesheet" href="/assets/css/animate.css">
         <link rel="stylesheet" href="/assets/css/style.css">
    </head>
    <body id="login">
      <div class="wrapper">
      <div class="col-lg-3 col-md-3"></div>
      <div class="col-lg-6 col-md-6">
        <form class="form-signin" id="loginform" action="/api/account/login" method="POST">
          <h2 id="header-form" class="form-signin-heading form-head">Please login</h2>
          <input type="text" class="form-control" name="email" placeholder="Email..." id="email" required="" autofocus="" />
          <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
        </div>
      </div>

        <script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript">

            $(function(){

                $(document).on('submit', '#loginform', function(e){

                    e.preventDefault();

                    var ajax = $.post('/api/account/login', $('#loginform').serialize());
                    
                    ajax.done(function(serverData) {

                     if(serverData.url)
                           window.location.href= serverData.url;

                    });

                });



            });

        </script>

    </body>
</html>