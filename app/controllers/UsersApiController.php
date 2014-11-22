<?php

class UsersApiController extends BaseController {

    public function __construct(){
        $this->beforeFilter('auth.token');
    }

    public function getUserInfo(){
        $userAuth=Token::getUserInstance();
        return User::find($userAuth->id)->donations;
    }

}
