<?php

class DonationsController extends BaseController {

	/**
	 * Donation Repository
	 *
	 * @var Donation
	 */
	protected $donation;

	public function __construct(Donation $donation)
	{
		$this->donation = $donation;
	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index($ins)
	{
		$donations = $this->donation->where('institution','=', $ins)->get();

        $bloodGroups = Bloodgroup::all();

		return View::make('donations.index', ['bloodGroups' => $bloodGroups,'donations' => $donations, 'ins' => $ins]);
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create($ins)
	{
        $users = User::lists('name', 'id');

        $inst = Institution::lists('name', 'id');

        $events = Bloodevent::lists('title', 'id');

        $bloodGroups = Bloodgroup::lists('name','id');

		return View::make('donations.create', ['bloodGroups' => $bloodGroups, 'events' => $events, 'users' => $users, 'inst' => $inst, 'ins' => $ins]);
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store($ins)
	{
		$input = Input::all();

		$validation = Validator::make($input, Donation::$rules);

		if ($validation->passes())
		{
			$this->donation->create($input);

            $institution = Institution::where('id','=', Input::get('institution'))->first();

            $institution->blood_level += Input::get('quantity');

            $institution->save();

            $user = User::where('id', '=', Input::get('user_id'))->first();

            $user->points += 1;

            if($user->points <= 3)
                $user->rank = 'Donor';
            else if($user->points >3 && $user->points <= 6)
                $user->rank = 'Hero';
            else
                $user->rank = 'Life saver';

            $user->save();

			return Redirect::route('donations.index', $ins);
		}

		return Redirect::route('donations.create')
			->withInput()
			->withErrors($validation)
			->with('message', 'There were validation errors.');
	}

	/**
	 * Display the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($ins, $id)
	{
		$donation = $this->donation->findOrFail($id);

        $bloodGroups = Bloodgroup::all();

		return View::make('donations.show', ['bloodGroups' => $bloodGroups,'donation' => $donation, 'ins' => $ins]);
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($ins ,$id)
	{
		$donation = $this->donation->find($id);

        $bloodGroups = Bloodgroup::lists('name','id');

		if (is_null($donation))
		{
			return Redirect::route('donations.index');
		}

		return View::make('donations.edit', ['donation' => $donation, 'ins' => $ins, 'bloodGroups' => $bloodGroups]);
	}

	/**
	 * Update the specified resource in storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($ins, $id)
	{

		$input = array_except(Input::all(), '_method');
		$validation = Validator::make($input, Donation::$rules);

		if ($validation->passes())
		{
			$donation = $this->donation->find($id);
			$donation->update($input);

			return Redirect::route('donations.show', [$ins, $id]);
		}

		return Redirect::route('donations.edit', [$ins, $id])
			->withInput()
			->withErrors($validation)
			->with('message', 'There were validation errors.');
	}

	/**
	 * Remove the specified resource from storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($ins, $id)
	{
		$this->donation->find($id)->delete();

		return Redirect::route('donations.index', $ins);
	}

    public function showByInstitution($index){

        $instDonations = Donation::where('institution', '=', $index)->get();

        //dd($instDonations);

        return View::make('donations.index', [ 'donations' => $instDonations ]);

    }
    public function sendPush(){
         $message=json_encode(['title'=>'FIRST BLOOD','message'=>'Killing spree']);
          PushNotification::app('appNameAndroid')
            ->to('APA91bG7adyRCI3UF9q5ge3RSQmHnzfLB6XBpZAGg1Yvr9qYPCuiC8J4N4OQMS6qcPr5zTwJqQlEOi-cFioMqIwLVganOyREIoFeGg1CmYBd2Qp1Ii_vUAPPH6GXLxigISeOMiP6fiaRxRAQ1TPwFqg7ivaxvbUSJw')
            ->send($message);
    }

    public function byBloodGroup($ins, $group){

        $donations = Donation::where('institution', '=', $ins)->get();

        $bloodGroups = Bloodgroup::all();

        //dd($bloodGroups);

        return View::make('donations.bloodgroup', ['group' => $group, 'bloodGroups' => $bloodGroups ,'ins' => $ins ,'donations' => $donations]);

    }

    public function editEvent($id){

        return null;

    }

    public function eventUpdate($id){

        $input = array_except(Input::all(), '_method');
        $validation = Validator::make($input, Donation::$rules);

        if ($validation->passes())
        {
            $donation = $this->donation->find($id);
            $donation->update($input);

            return Redirect::route('institutionEvents', [$id]);
        }

        return Redirect::route('institutionEvents', [$id])
            ->withInput()
            ->withErrors($validation)
            ->with('message', 'There were validation errors.');

    }

}
