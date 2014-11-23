<?php

class BloodeventsController extends BaseController {

	/**
	 * Bloodevent Repository
	 *
	 * @var Bloodevent
	 */
	protected $bloodevent;

	public function __construct(Bloodevent $bloodevent)
	{

		$this->beforeFilter('auth.token',["only"=>"eventByDonation"]);
        $this->bloodevent = $bloodevent;

	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$bloodevents = $this->bloodevent->all();

		return View::make('bloodevents.index', compact('bloodevents'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('bloodevents.create');
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Bloodevent::$rules);

		if ($validation->passes())
		{
			$this->bloodevent->create($input);

			return Redirect::route('bloodevents.index');
		}

		return Redirect::route('bloodevents.create')
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
	public function show($id)
	{
		$bloodevent = $this->bloodevent->findOrFail($id);

		return View::make('bloodevents.show', compact('bloodevent'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$bloodevent = $this->bloodevent->find($id);

		if (is_null($bloodevent))
		{
			return Redirect::route('bloodevents.index');
		}

		return View::make('bloodevents.edit', compact('bloodevent'));
	}

	/**
	 * Update the specified resource in storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($id)
	{
		$input = array_except(Input::all(), '_method');
		$validation = Validator::make($input, Bloodevent::$rules);

		if ($validation->passes())
		{
			$bloodevent = $this->bloodevent->find($id);
			$bloodevent->update($input);

			return Redirect::route('bloodevents.show', $id);
		}

		return Redirect::route('bloodevents.edit', $id)
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
	public function destroy($id)
	{
		$this->bloodevent->find($id)->delete();

		return Redirect::route('bloodevents.index');
	}
    public function eventByDonation($donationId){
        return Donation::with('events')->find($donationId)->events;
    }
}
