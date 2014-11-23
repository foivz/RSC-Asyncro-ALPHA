<html>

    <head>
          <link rel="stylesheet" href="/assets/css/bootstrap.css">
          <title>Sanguio</title>
          <link rel="shortcut icon" href="/assets/img/favicon.ico" type="image/x-icon" />
                 <link rel="stylesheet" href="/assets/css/animate.css">
                 <link rel="stylesheet" href="/assets/css/style.css">
           <meta name="google-translate-customization" content="89d5308248a4c0c6-9ecd1297e13e1f29-g7ff0e872a6eff02e-d"></meta>
              <style type="text/css">iframe.goog-te-banner-frame{ display: none !important;}</style>
                   <style type="text/css">body {position: static !important; top:0px !important;}</style>
    </head>

    <body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Sanguio</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            @if($user->hasRole('SuperAdmin'))
            <li><a href="/users">Users</a></li>
            @endif
            <li><a href="/institutions">Institutions</a></li>
            <li><a href="/bloodevents">Events</a></li>
            <li>
              <div id="google_translate_element"></div><script type="text/javascript">
                                        function googleTranslateElementInit() {
                                          new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages: 'de,en,es,fr,pt,ru', autoDisplay: false}, 'google_translate_element');
                                        }
                                        </script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>

                </div></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/account/logout">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
</nav>
      <a href="/institutions">Institutions</a>

    </body>


</html>