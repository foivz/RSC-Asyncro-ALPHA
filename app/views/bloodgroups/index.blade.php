@extends('layouts.scaffold')

@section('main')

<h1>All Bloodgroups</h1>

<p>{{ link_to_route('bloodgroups.create', 'Add New Bloodgroup', null, array('class' => 'btn btn-lg btn-success')) }}</p>

@if ($bloodgroups->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>Note</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($bloodgroups as $bloodgroup)
				<tr>
					<td>{{{ $bloodgroup->name }}}</td>
					<td>{{{ $bloodgroup->note }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('bloodgroups.destroy', $bloodgroup->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('bloodgroups.edit', 'Edit', array($bloodgroup->id), array('class' => 'btn btn-info')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no bloodgroups
@endif

@stop
