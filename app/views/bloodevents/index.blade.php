@extends('layouts.scaffold')

@section('main')

<h1>All Bloodevents</h1>

<p>{{ link_to_route('bloodevents.create', 'Add New Bloodevent', null, array('class' => 'btn btn-lg btn-success')) }}</p>

@if ($bloodevents->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Location</th>
				<th>Time</th>
				<th>Logo</th>
				<th>Institution_id</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($bloodevents as $bloodevent)
				<tr>
					<td>{{{ $bloodevent->title }}}</td>
					<td>{{{ $bloodevent->location }}}</td>
					<td>{{{ $bloodevent->time }}}</td>
					<td>{{{ $bloodevent->logo }}}</td>
					<td>{{{ $bloodevent->institution_id }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block; margin-top:0;', 'method' => 'DELETE', 'route' => array('bloodevents.destroy', $bloodevent->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger', 'style' => 'margin-top:0;')) }}
                        {{ Form::close() }}
                        {{ link_to_route('bloodevents.edit', 'Edit', array($bloodevent->id), array('class' => 'btn btn-info', 'style' =>'margin-top:0;')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no bloodevents
@endif

@stop
