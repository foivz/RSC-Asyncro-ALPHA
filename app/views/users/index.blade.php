@extends('layouts.scaffold')

@section('main')

<h1>All Users</h1>

<p>{{ link_to_route('users.create', 'Add New User', null, array('class' => 'btn btn-lg btn-success')) }}</p>

@if ($users->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Email</th>
				<th>Password</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Points</th>
				<th>Num_of_donations</th>
				<th>Rank</th>
				<th>Avatar</th>
				<th>Blood_group</th>
				<th>City</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($users as $user)
				<tr>
					<td>{{{ $user->email }}}</td>
					<td>{{{ $user->password }}}</td>
					<td>{{{ $user->name }}}</td>
					<td>{{{ $user->surname }}}</td>
					<td>{{{ $user->points }}}</td>
					<td>{{{ $user->num_of_donations }}}</td>
					<td>{{{ $user->rank }}}</td>
					<td>{{{ $user->avatar }}}</td>
					<td>{{{ $user->blood_group }}}</td>
					<td>{{{ $user->city }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('users.destroy', $user->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('users.edit', 'Edit', array($user->id), array('class' => 'btn btn-info')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no users
@endif

@stop
