<?php

class Institution extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		'name' => 'required',
		'lat' => 'required',
		'lng' => 'required',
		'description' => 'required',
		'phone' => 'required',
		'email' => 'required',
		'blood_level' => 'required',
		'logo' => 'required',
		'picture' => 'required'
	);
    public function donations(){
        return $this->hasMany('Donation');
    }
    public function city(){
        return $this->belongsTo('City');
    }
    public function users(){
        return $this->belongsToMany('User','follows','user_id','institution_id');
    }
}
