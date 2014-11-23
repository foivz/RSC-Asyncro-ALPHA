<?php

class FollowsController extends BaseController {

	/**
	 * Follow Repository
	 *
	 * @var Follow
	 */
	protected $follow;

	public function __construct(Follow $follow)
	{
		$this->follow = $follow;
	}

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		$follows = $this->follow->all();

		return View::make('follows.index', compact('follows'));
	}

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		return View::make('follows.create');
	}

	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		$input = Input::all();
		$validation = Validator::make($input, Follow::$rules);

		if ($validation->passes())
		{
			$this->follow->create($input);

			return Redirect::route('follows.index');
		}

		return Redirect::route('follows.create')
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
		$follow = $this->follow->findOrFail($id);

		return View::make('follows.show', compact('follow'));
	}

	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		$follow = $this->follow->find($id);

		if (is_null($follow))
		{
			return Redirect::route('follows.index');
		}

		return View::make('follows.edit', compact('follow'));
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
		$validation = Validator::make($input, Follow::$rules);

		if ($validation->passes())
		{
			$follow = $this->follow->find($id);
			$follow->update($input);

			return Redirect::route('follows.show', $id);
		}

		return Redirect::route('follows.edit', $id)
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
		$this->follow->find($id)->delete();

		return Redirect::route('follows.index');
	}

}
