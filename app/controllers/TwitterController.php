<?php

class TwitterController extends BaseController {

    public function login(){
        // your SIGN IN WITH TWITTER  button should point to this route
        $sign_in_twitter = TRUE;
        $force_login = FALSE;
        $callback_url = 'http://' . $_SERVER['HTTP_HOST'] . '/account/twitter/callback';
        // Make sure we make this request w/o tokens, overwrite the default values in case of login.
        Twitter::set_new_config(array('token' => '', 'secret' => ''));
        $token = Twitter::getRequestToken($callback_url);
        if( isset( $token['oauth_token_secret'] ) ) {
            $url = Twitter::getAuthorizeURL($token, $sign_in_twitter, $force_login);

            Session::put('oauth_state', 'start');
            Session::put('oauth_request_token', $token['oauth_token']);
            Session::put('oauth_request_token_secret', $token['oauth_token_secret']);

            return Redirect::to($url);
        }
        return Redirect::to('twitter/error');

    }

    public function callback(){
// You should set this route on your Twitter Application settings as the callback
        // https://apps.twitter.com/app/YOUR-APP-ID/settings
        if(Session::has('oauth_request_token')) {
            $request_token = array(
                'token' => Session::get('oauth_request_token'),
                'secret' => Session::get('oauth_request_token_secret'),
            );

            Twitter::set_new_config($request_token);

            $oauth_verifier = FALSE;
            if(Input::has('oauth_verifier')) {
                $oauth_verifier = Input::get('oauth_verifier');
            }

            // getAccessToken() will reset the token for you
            $token = Twitter::getAccessToken( $oauth_verifier );
            if( !isset( $token['oauth_token_secret'] ) ) {
                return Redirect::to('/')->with('flash_error', 'We could not log you in on Twitter.');
            }

            $credentials = Twitter::query('account/verify_credentials');
            if( is_object( $credentials ) && !isset( $credentials->error ) ) {

                $user = User::where('email', '=', $credentials->id_str)->first();

                if(!$user) {

                    $user = new User();

                    $user->email = $credentials->id_str;

                    $user->name = $credentials->name;

                    $user->token = Input::get('oauth_token');

                    $user->twitterid = $credentials->id_str;

                    $user->save();

                    $userRole = Role::find(3);
                    $user->attachRole($userRole);

                    $authToken = AuthToken::create($user);
                    $publicToken = AuthToken::publicToken($authToken);

                    return [ 'status' => 'true', 'auth_token' => $publicToken ];

                    // $credentials contains the Twitter user object with all the info about the user.
                    // Add here your own user logic, store profiles, create new users on your tables...you name it!
                    // Typically you'll want to store at least, user id, name and access tokens
                    // if you want to be able to call the API on behalf of your users.

                    // This is also the moment to log in your users if you're using Laravel's Auth class
                    // Auth::login($user) should do the trick.

                    //return Redirect::to('/')->with('flash_notice', "Congrats! You've successfully signed in!");
                }else{
                    $authToken = AuthToken::create($user);
                    $publicToken = AuthToken::publicToken($authToken);

                    return [ 'status' => 'true', 'auth_token' => $publicToken ];
                }
            }
            return Redirect::to('/')->with('flash_error', 'Crab! Something went wrong while signing you up!');
        }

    }

    public function error(){

        return [ 'error' => 'something went wrong' ];

    }


}
