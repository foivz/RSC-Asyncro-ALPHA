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
	public function index()
	{
		$donations = $this->donation->all();

		return View::make('donations.index', compact('donations'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('donations.create');
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
	public function show($id)
	{
		$donation = $this->donation->findOrFail($id);

		return View::make('donations.show', compact('donation'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$donation = $this->donation->find($id);

		if (is_null($donation))
		{
			return Redirect::route('donations.index');
		}

		return View::make('donations.edit', compact('donation'));
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
		$validation = Validator::make($input, Donation::$rules);

		if ($validation->passes())
		{
			$donation = $this->donation->find($id);
			$donation->update($input);

			return Redirect::route('donations.show', $id);
		}

		return Redirect::route('donations.edit', $id)
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
		$this->donation->find($id)->delete();

		return Redirect::route('donations.index');
	}

}
