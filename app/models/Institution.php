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
}
