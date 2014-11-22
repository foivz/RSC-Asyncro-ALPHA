@extends('layouts.scaffold')

@section('main')

<h1>Show Institution</h1>

<p>{{ link_to_route('institutions.index', 'Return to All institutions', null, array('class'=>'btn btn-lg btn-primary')) }}</p>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
				<th>Lat</th>
				<th>Lng</th>
				<th>Description</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Blood_level</th>
				<th>Logo</th>
				<th>Picture</th>
		</tr>
	</thead>

	<tbody>
		<tr>
			<td>{{{ $institution->name }}}</td>
					<td>{{{ $institution->lat }}}</td>
					<td>{{{ $institution->lng }}}</td>
					<td>{{{ $institution->description }}}</td>
					<td>{{{ $institution->phone }}}</td>
					<td>{{{ $institution->email }}}</td>
					<td>{{{ $institution->blood_level }}}</td>
					<td>{{{ $institution->logo }}}</td>
					<td>{{{ $institution->picture }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('institutions.destroy', $institution->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('institutions.edit', 'Edit', array($institution->id), array('class' => 'btn btn-info')) }}
                    </td>
		</tr>
	</tbody>
</table>

@stop
