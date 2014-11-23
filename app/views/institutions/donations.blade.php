@extends('layouts.scaffold')

@section('main')

<h1>All Donations</h1>


@if ($donations->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Date</th>
				<th>Quantity</th>
				<th>Note</th>
				<th>Blood group</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($donations as $donation)
				<tr>
					<td>{{{ $donation->date }}}</td>
					<td>{{{ $donation->quantity }}}</td>
					<td>{{{ $donation->note }}}</td
					<td>{{{$donation->bloodgroups_id}}}</td>
                    <td>
                        {{ link_to_route('eventDonationsEdit', 'Edit', [$ins,$donation->id], array('class' => 'btn btn-info')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no donations
@endif

@stop
