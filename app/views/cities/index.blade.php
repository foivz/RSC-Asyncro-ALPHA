@extends('layouts.scaffold')

@section('main')

<h1>All Cities</h1>

<p>{{ link_to_route('cities.create', 'Add New City', null, array('class' => 'btn btn-lg btn-success')) }}</p>

@if ($cities->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Lat</th>
				<th>Lng</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($cities as $city)
				<tr>
					<td>{{{ $city->name }}}</td>
					<td>{{{ $city->lat }}}</td>
					<td>{{{ $city->lng }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('cities.destroy', $city->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('cities.edit', 'Edit', array($city->id), array('class' => 'btn btn-info')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no cities
@endif

@stop
