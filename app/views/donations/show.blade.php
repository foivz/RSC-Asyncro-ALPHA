@extends('layouts.scaffold')

@section('main')

<h1>Show Donation</h1>

<p>{{ link_to_route('donations.index', 'Return to All donations', [$ins], array('class'=>'btn btn-lg btn-primary')) }}</p>

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
	</tbody>
</table>

@stop
