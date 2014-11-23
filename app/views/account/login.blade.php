<html>
    <head>


    </head>
    <body>

        <h2>Login form</h2>

        <form id="loginform" action="/api/account/login" method="POST">

            <input type="text" name="email" placeholder="Email..." id="email"/>

            <input type="password" name="password" placeholder="Password..." id="password"/>

            <input type="submit" id="sbn-btn"/>

        </form>

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