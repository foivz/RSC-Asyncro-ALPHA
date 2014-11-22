@extends('layouts.scaffold')

@section('main')

<h1>All Donations</h1>

<p>{{ link_to_route('donations.create', 'Add New Donation', null, array('class' => 'btn btn-lg btn-success')) }}</p>

@if ($donations->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Date</th>
				<th>Quantity</th>
				<th>Note</th>
				<th>Blood_group</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($donations as $donation)
				<tr>
					<td>{{{ $donation->date }}}</td>
					<td>{{{ $donation->quantity }}}</td>
					<td>{{{ $donation->note }}}</td>
					<td>{{{ $donation->blood_group }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('donations.destroy', $ins,$donation->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('donations.edit', 'Edit', array($ins,$donation->id), array('class' => 'btn btn-info')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no donations
@endif

@stop
