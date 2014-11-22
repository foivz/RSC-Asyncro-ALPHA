<?php

class BloodgroupsController extends BaseController {

	/**
	 * Bloodgroup Repository
	 *
	 * @var Bloodgroup
	 */
	protected $bloodgroup;

	public function __construct(Bloodgroup $bloodgroup)
	{
		$this->bloodgroup = $bloodgroup;
	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$bloodgroups = $this->bloodgroup->all();

		return View::make('bloodgroups.index', compact('bloodgroups'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('bloodgroups.create');
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Bloodgroup::$rules);

		if ($validation->passes())
		{
			$this->bloodgroup->create($input);

			return Redirect::route('bloodgroups.index');
		}

		return Redirect::route('bloodgroups.create')
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
		$bloodgroup = $this->bloodgroup->findOrFail($id);

		return View::make('bloodgroups.show', compact('bloodgroup'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$bloodgroup = $this->bloodgroup->find($id);

		if (is_null($bloodgroup))
		{
			return Redirect::route('bloodgroups.index');
		}

		return View::make('bloodgroups.edit', compact('bloodgroup'));
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
		$validation = Validator::make($input, Bloodgroup::$rules);

		if ($validation->passes())
		{
			$bloodgroup = $this->bloodgroup->find($id);
			$bloodgroup->update($input);

			return Redirect::route('bloodgroups.show', $id);
		}

		return Redirect::route('bloodgroups.edit', $id)
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
		$this->bloodgroup->find($id)->delete();

		return Redirect::route('bloodgroups.index');
	}

}
