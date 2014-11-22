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

		return View::make('donations.index', ['donations' => $donations, 'ins' => $ins]);
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

        $events = null;

        //$events = Event::lists('title', 'id');

		return View::make('donations.create', ['events' => $events, 'users' => $users, 'inst' => $inst, 'ins' => $ins]);
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Donation::$rules);

		if ($validation->passes())
		{
			$this->donation->create($input);

			return Redirect::route('donations.index');
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

		return View::make('donations.show', ['donation' => $donation, 'ins' => $ins]);
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

		if (is_null($donation))
		{
			return Redirect::route('donations.index');
		}

		return View::make('donations.edit', ['donation' => $donation, 'ins' => $ins]);
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
          PushNotification::app('appNameAndroid')
            ->to('123')
            ->send('Hello World, i`m a push message');
    }

}
