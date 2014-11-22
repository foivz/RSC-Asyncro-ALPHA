<?php

class EventsController extends BaseController {

	/**
	 * Event Repository
	 *
	 * @var Event
	 */
	protected $event;

	public function __construct(Event $event)
	{
		$this->event = $event;
	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$events = $this->event->all();

		return View::make('events.index', compact('events'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('events.create');
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Event::$rules);

		if ($validation->passes())
		{
			$this->event->create($input);

			return Redirect::route('events.index');
		}

		return Redirect::route('events.create')
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
		$event = $this->event->findOrFail($id);

		return View::make('events.show', compact('event'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$event = $this->event->find($id);

		if (is_null($event))
		{
			return Redirect::route('events.index');
		}

		return View::make('events.edit', compact('event'));
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
		$validation = Validator::make($input, Event::$rules);

		if ($validation->passes())
		{
			$event = $this->event->find($id);
			$event->update($input);

			return Redirect::route('events.show', $id);
		}

		return Redirect::route('events.edit', $id)
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
		$this->event->find($id)->delete();

		return Redirect::route('events.index');
	}

}
