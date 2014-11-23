<?php

class Donation extends Eloquent {
	protected $guarded = array();

	public static $rules = array(
		/*'user_id' => 'required',
		'institution' => 'required',*/
		'date' => 'required',
		'quantity' => 'required',
		'note' => 'required',
		'bloodgroups_id' => 'required',
		//'collecting_blood_event' => 'required'
	);
    public function user(){
        return $this->belongsTo('User');
    }
    public function events(){
        return $this->belongsTo('Bloodevent','bloodevents_id');
    }
    public function institution(){
        return $this->belongsTo('institution');
    }
}
