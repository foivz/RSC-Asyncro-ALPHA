<?php

class PanelController extends \BaseController {

    public function __construct(){

        $this->beforeFilter('auth');

        $this->beforeFilter('bothRoles');

    }

    public function index(){

        return View::make('admin.index');

    }

}