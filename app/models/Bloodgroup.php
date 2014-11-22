<?php

class Bloodgroup extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		'name' => 'required',
		'note' => 'required'
	);
}
