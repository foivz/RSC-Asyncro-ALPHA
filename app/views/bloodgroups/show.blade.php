@extends('layouts.scaffold')

@section('main')

<h1>Show Bloodgroup</h1>

<p>{{ link_to_route('bloodgroups.index', 'Return to All bloodgroups', null, array('class'=>'btn btn-lg btn-primary')) }}</p>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
				<th>Note</th>
		</tr>
	</thead>

	<tbody>
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
	</tbody>
</table>

@stop
