<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/
Route::get('/',function(){
    return View::make('home.index');
});
/**************Views******************/
Route::get('/admin', ['as' => 'adminPanelRoute', 'uses' => 'PanelController@index']);
Route::get('/account/logout', [ 'as' => 'logoutRoute', 'uses' => 'AccountController@logout' ]);
Route::get('/account/login', [ 'as' => 'loginRoute', 'uses' => 'AccountController@loginForm' ]);
Route::get('/account/register', [ 'as' => 'registerRoute', 'uses' => 'AccountController@registerForm' ]);
Route::get('/account/login/twitter', [ 'as' => 'twitterLoginRoute', 'uses' => 'TwitterController@login' ]);
Route::get('/account/twitter/callback', [ 'as' => 'twitterCallbackRoute', 'uses' => 'TwitterController@callback' ]);
/**************Views******************/

/***************API******************/
Route::post('/api/account/registration', ['as' => 'registerApiRoute', 'uses' => 'AccountApiController@register']);
Route::post('/api/account/login', ['as' => 'loginApiRoute', 'uses' => 'AccountApiController@login']);
Route::post('/api/account/forgot', ['as' => 'forgotApiRoute', 'uses' => 'AccountApiController@forgot']);
Route::post('/api/account/reset', ['as' => 'resetApiRoute', 'uses' => 'AccountApiController@reset']);
Route::post('/api/user/fetch', ['as' => 'fetchUserRoute', 'uses' => 'UsersApiController@getUserInfo']);
Route::post('/api/donation/fetch', ['as' => 'fetchDonationRoute', 'uses' => 'DonationsApiController@getUserDonations']);
Route::post('/api/account/update', ['as' => 'updateAccountRoute', 'uses' => 'AccountApiController@updateProfileInfo']);
Route::get('/api/account/login/twitter', [ 'as' => 'twitterLoginRoute', 'uses' => 'TwitterController@login' ]);
Route::get('/api/account/twitter/callback', [ 'as' => 'twitterCallbackRoute', 'uses' => 'TwitterController@callback' ]);
Route::post('/api/1/institution/{id}', [ 'as' => 'fetchinstitution', 'uses' => 'InstitutionsController@institutionByDonation' ]);
Route::post('/api/1/fetch/event/{donationId}', [ 'as' => 'fetchevent', 'uses' => 'BloodeventsController@eventByDonation']);
Route::get('/institutions/supply/{id}', ['as' => 'institutionBloodSupply', 'uses' => 'DonationsController@showByInstitution']);
Route::get('/users/institution/{id}', ['as' => 'usersForInstitution', 'uses' => 'InstitutionsController@getUsers']);
Route::post('/api/1/institutions/all',['as'=>'institutionsList','uses'=>'InstitutionsController@listInstitutions']);
/***************API******************/
Route::group(array('before' => 'auth.token'), function() {
    Route::post('api/data', function(){
        return Token::getUserInstance();
    });
});


/***************************AuthToken*****************************/
Route::get('auth', 'Tappleby\AuthToken\AuthTokenController@index');
Route::post('auth', 'Tappleby\AuthToken\AuthTokenController@store');
Route::delete('auth', 'Tappleby\AuthToken\AuthTokenController@destroy');
/***************************AuthToken*****************************/

/**************************Resource******************************/
Route::resource('users', 'UsersController');
Route::resource('institutions', 'InstitutionsController');

Route::get('/donations/push', [ 'as' => 'donations.pushnotification', 'uses' => 'DonationsController@sendPush' ]);
Route::get('/donations/{ins}', [ 'as' => 'donations.index', 'uses' => 'DonationsController@index' ]);
Route::get('/donations/{ins}/create', [ 'as' => 'donations.create', 'uses' => 'DonationsController@create' ]);
Route::get('/donations/{ins}/show/{id}', [ 'as' => 'donations.show', 'uses' => 'DonationsController@show' ]);
Route::post('/donations/{ins}/store', [ 'as' => 'donations.store', 'uses' => 'DonationsController@store' ]);
Route::get('/donations/{ins}/destroy/{id}', [ 'as' => 'donations.destroy', 'uses' => 'DonationsController@destroy' ]);
Route::get('/donations/{ins}/edit/{id}', [ 'as' => 'donations.edit', 'uses' => 'DonationsController@edit' ]);
Route::patch('/donations/{ins}/update/{id}', [ 'as' => 'donations.update', 'uses' => 'DonationsController@update' ]);

//Route::resource('donations', 'DonationsController');


Route::resource('events', 'EventsController');
Route::resource('bloodevents', 'BloodeventsController');


Route::resource('bloodgroups', 'BloodgroupsController');

Route::resource('cities', 'CitiesController');



Route::resource('follows', 'FollowsController');