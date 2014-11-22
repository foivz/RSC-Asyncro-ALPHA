<?php

class Bloodevent extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		'title' => 'required',
		'location' => 'required',
		'time' => 'required',
		'logo' => 'required',
		'institution_id' => 'required'
	);
}
