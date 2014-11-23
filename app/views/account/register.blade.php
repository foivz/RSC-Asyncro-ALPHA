<html>
    <head>

        <title>Sanguio</title>
        <link rel="shortcut icon" href="/assets/img/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" href="/assets/css/bootstrap.css">
        <link rel="stylesheet" href="/assets/css/animate.css">
        <link rel="stylesheet" href="/assets/css/style.css">

    </head>
    <body id="login">
          <div class="wrapper">
          <div class="col-lg-3 col-md-3"></div>
          <div class="col-lg-6 col-md-6">
            <form class="form-signin" id="registerform" action="/api/account/registration" method="POST" name="registration-data" enctype="multipart/form-data">
              <h2 id="header-form" class="form-signin-heading form-head">Please register</h2>
              <input type="text" class="form-control" name="email" placeholder="Email..." id="email" required="" autofocus="" />
              <input type="password" class="form-control" name="password" placeholder="Password" id="password" required=""/>
              <input type="file" class="form-control" name="avatar" id="avatar"/>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>
            </div>
          </div>


    </body>
    <script src="//code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">

        $(function(){

            $(document).on('submit', '#registerform', function(e){

                e.preventDefault();

                var ajax = $.post('/api/account/registration', $('#registerform').serialize());

                ajax.done(function(serverData) {

                    if(serverData.status === 'true')
                        window.location.href = '/account/login';

                });

            });

        });

    </script>
</html>