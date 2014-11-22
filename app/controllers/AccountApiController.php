<?php

use Faker\Factory as Faker;

class AccountApiController extends \BaseController {

    public function __construct(){

        $this->beforeFilter('auth.token', [ 'except' => ['register', 'login'] ]);

    }

	public function register(){

        $password = Input::get('password');

        $email = Input::get('email');

        if(!empty($password) && !empty($email)) {
            $newUser = new User();

            $newUser->fill(Input::except(['_token', 'password']));

            $newUser->password = Hash::make(Input::get('password'));

            FileUpload::saveImage('/uploads', 'avatar');

            try{

                $newUser->save();
                $userRole=Role::find(3);
                $newUser->attachRole($userRole);
            }catch (Exception $e){

                return [ 'status' => 'false' ];

            }

            return [ 'status' => 'true' ];

        }else
            return [ 'status' => 'false' ];

    }

    public function login(){

        if(Auth::attempt([ 'email' => Input::get('email'), 'password' => Input::get('password') ], true))
        {
            $authToken = AuthToken::create(Auth::user());
            $publicToken = AuthToken::publicToken($authToken);
            return [ 'status' => 'true', 'token' => $publicToken ];
        }else{

            return [ 'status' => 'false' ];

        }

    }

    public function forgot(){

        $input = Input::except('_token');

        $userInstance = Token::getUserInstance();

        $fake = Faker::create();

        $newPassword = $fake->userName();

        $userInstance->password = Hash::make($newPassword);

        return [ 'status' => true, 'password' => $newPassword ];

    }

    public function reset(){

        $input = Input::except('_token');

        $userInstance = Token::getUserInstance();

        $oldPassword = Input::get('oldpassword');

        if(Hash::check($oldPassword, $userInstance->password)){

            $userInstance->password = Hash::make($input['newpassword']);

            $userInstance->save();

            return [ 'status' => true ,'newpassword' => $input['newpassword'] ];

        }else {
            return ['status' => false];
        }
    }

}