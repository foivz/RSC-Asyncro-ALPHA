<?php

class InstitutionsController extends BaseController {

	/**
	 * Institution Repository
	 *
	 * @var Institution
	 */
	protected $institution;

	public function __construct(Institution $institution)
	{
		$this->institution = $institution;
	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$institutions = $this->institution->all();

		return View::make('institutions.index', compact('institutions'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('institutions.create');
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Institution::$rules);

		if ($validation->passes())
		{
			$this->institution->create($input);

			return Redirect::route('institutions.index');
		}

		return Redirect::route('institutions.create')
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
		$institution = $this->institution->findOrFail($id);

		return View::make('institutions.show', compact('institution'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$institution = $this->institution->find($id);

		if (is_null($institution))
		{
			return Redirect::route('institutions.index');
		}

		return View::make('institutions.edit', compact('institution'));
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
		$validation = Validator::make($input, Institution::$rules);

		if ($validation->passes())
		{
			$institution = $this->institution->find($id);
			$institution->update($input);

			return Redirect::route('institutions.show', $id);
		}

		return Redirect::route('institutions.edit', $id)
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
		$this->institution->find($id)->delete();

		return Redirect::route('institutions.index');
	}

}
