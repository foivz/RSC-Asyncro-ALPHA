@extends('layouts.scaffold')

@section('main')

<h1>All Institutions</h1>

{{ link_to_route('institutions.index', 'Back to all', null, array('class' => 'btn btn-info')) }}

@if ($events->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Location</th>
				<th>Time</th>
				<th>Logo</th>
				<th>Institution</th>
				<th>Donations</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($events as $event)
				<tr>
					<td>{{{ $event->title }}}</td>
					<td>{{{ $event->location }}}</td>
					<td>{{{$event->time}}}</td>
					<td>{{{$event->logo}}}</td>
					<td>{{{$name}}}</td>
					<td>{{ link_to_route('eventDonations', 'Donations', [$ins,$event->id], array('class' => 'btn btn-info', 'style' => 'margin-top:0;')) }}</td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no institutions
@endif

@stop
