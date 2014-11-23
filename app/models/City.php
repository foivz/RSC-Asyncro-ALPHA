<?php

class City extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		'name' => 'required',
		'lat' => 'required',
		'lng' => 'required'
	);
    public function institutions(){
        return $this->hasMany('Institution');
    }
}
