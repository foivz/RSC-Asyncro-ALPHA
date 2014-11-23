<?php

use Faker\Factory as Faker;

class AccountApiController extends \BaseController {

    public function __construct(){

        $this->beforeFilter('auth.token', [ 'except' => ['register', 'login', 'forgot'] ]);

    }

	public function register(){

        $password = Input::get('password');

        $email = Input::get('email');

        if(!empty($password) && !empty($email)) {
            $newUser = new User();

            $newUser->fill(Input::except(['_token', 'password']));

            $newUser->password = Hash::make(Input::get('password'));

            $newUser->gcm_regid = Input::get('reg_id');

            //FileUpload::saveImage('/uploads', 'avatar');

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

        $user = User::where('email', '=', Input::get('email'))->where('counter','<', 3)->first();

        if($user) {

            if (Auth::attempt(['email' => Input::get('email'), 'password' => Input::get('password')], true)) {
                $authToken = AuthToken::create(Auth::user());
                $publicToken = AuthToken::publicToken($authToken);
                return ['status' => 'true', 'token' => $publicToken, 'url' => '/admin'];
            } else {

                $user = User::where('email', '=', $email)->first();

                if ($user) {
                    $user->counter = $user->counter + 1;

                    $user->save();
                }

                return ['status' => 'false'];

            }
        }else{
            return ['status' => 'false'];
        }

    }

    public function forgot(){

        $input = Input::except('_token');

        $userInstance = User::where('email', '=', Input::get('email'))->first();

        $fake = Faker::create();

        $newPassword = $fake->userName();

        $userInstance->password = Hash::make($newPassword);

        $userInstance->counter = 0;

        $userInstance->save();

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

    public function updateProfileInfo(){

        $token = Input::get('auth_token');

        $userInstance = Token::getUserInstance();

        $userInstance->email = Input::get('email');

        $userInstance->name = Input::get('name');

        $userInstance->surname = Input::get('surname');

        try {

            $userInstance->save();

            return [ 'status' => 'true' ];

        }catch (Exception $e){

            return [ 'status' => 'false' ];
        }

    }

}