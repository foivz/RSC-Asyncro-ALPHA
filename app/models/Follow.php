<?php

class Follow extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		'user' => 'required',
		'institution' => 'required'
	);

}
