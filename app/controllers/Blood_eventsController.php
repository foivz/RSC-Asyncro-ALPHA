<?php

class Blood_eventsController extends BaseController {

	/**
	 * Blood_event Repository
	 *
	 * @var Blood_event
	 */
	protected $blood_event;

	public function __construct(Blood_event $blood_event)
	{
		$this->blood_event = $blood_event;
	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$blood_events = $this->blood_event->all();

		return View::make('blood_events.index', compact('blood_events'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('blood_events.create');
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Blood_event::$rules);

		if ($validation->passes())
		{
			$this->blood_event->create($input);

			return Redirect::route('blood_events.index');
		}

		return Redirect::route('blood_events.create')
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
		$blood_event = $this->blood_event->findOrFail($id);

		return View::make('blood_events.show', compact('blood_event'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$blood_event = $this->blood_event->find($id);

		if (is_null($blood_event))
		{
			return Redirect::route('blood_events.index');
		}

		return View::make('blood_events.edit', compact('blood_event'));
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
		$validation = Validator::make($input, Blood_event::$rules);

		if ($validation->passes())
		{
			$blood_event = $this->blood_event->find($id);
			$blood_event->update($input);

			return Redirect::route('blood_events.show', $id);
		}

		return Redirect::route('blood_events.edit', $id)
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
		$this->blood_event->find($id)->delete();

		return Redirect::route('blood_events.index');
	}

}
