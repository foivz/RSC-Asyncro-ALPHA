<?php

class Donation extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		/*'user_id' => 'required',
		'institution' => 'required',*/
		'date' => 'required',
		'quantity' => 'required',
		'note' => 'required',
		'blood_group' => 'required',
		//'collecting_blood_event' => 'required'
	);
    public function user(){
        return $this->belongsTo('User');
    }
    public function events(){
        return $this->belongsTo('Bloodevent');
    }
    public function institution(){
        return $this->belongsTo('institution');
    }
}
