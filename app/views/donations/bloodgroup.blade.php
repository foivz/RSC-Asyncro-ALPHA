@extends('layouts.scaffold')

@section('main')

<h1>Show Donation</h1>

<p>{{ link_to_route('donations.index', 'Return to All donations', [$ins], array('class'=>'btn btn-lg btn-primary')) }}</p>
<p>{{ link_to_route('donations.bybloodgroup', 'A+/-', [$ins, 0], array('class'=>'btn btn-lg btn-primary')) }}</p>
<p>{{ link_to_route('donations.bybloodgroup', 'B+/-', [$ins, 1], array('class'=>'btn btn-lg btn-primary')) }}</p>
<p>{{ link_to_route('donations.bybloodgroup', 'AB+/-', [$ins, 2], array('class'=>'btn btn-lg btn-primary')) }}</p>
<p>{{ link_to_route('donations.bybloodgroup', '0+/-', [$ins, 3], array('class'=>'btn btn-lg btn-primary')) }}</p>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Date</th>
				<th>Quantity</th>
				<th>Note</th>
				<th>Blood group</th>
		</tr>
	</thead>

	<tbody>
	    @foreach($donations as $donation)
	    @if($donation->bloodgroups_id === $bloodGroups[$group]->id)
		<tr>
			<td>{{{ $donation->date }}}</td>
					<td>{{{ $donation->quantity }}}</td>
					<td>{{{ $donation->note }}}</td>
					@foreach($bloodGroups as $group)
					    @if($group->id === $donation->bloodgroups_id)
					    <td>{{{ $group->name }}}</td>
					    @endif
					@endforeach
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('donations.destroy', $donation->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('donations.edit', 'Edit', array($ins,$donation->id), array('class' => 'btn btn-info')) }}
                    </td>
		</tr>
		@endif
		@endforeach
	</tbody>

</table>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Date</th>
				<th>Quantity</th>
				<th>Note</th>
				<th>Blood group</th>
		</tr>
	</thead>

	<tbody>
	    @foreach($donations as $donation)
	    @if($donation->bloodgroups_id === $bloodGroups[$group]->id)
		<tr>
			<td>{{{ $donation->date }}}</td>
					<td>{{{ $donation->quantity }}}</td>
					<td>{{{ $donation->note }}}</td>
					@foreach($bloodGroups as $group)
					    @if($group->id === $donation->bloodgroups_id)
					    <td>{{{ $group->name }}}</td>
					    @endif
					@endforeach
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('donations.destroy', $donation->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('donations.edit', 'Edit', array($ins,$donation->id), array('class' => 'btn btn-info')) }}
                    </td>
		</tr>
		@endif
		@endforeach
	</tbody>

</table>

@stop
