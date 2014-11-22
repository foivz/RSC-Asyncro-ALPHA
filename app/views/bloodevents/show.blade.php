@extends('layouts.scaffold')

@section('main')

<h1>Show Bloodevent</h1>

<p>{{ link_to_route('bloodevents.index', 'Return to All bloodevents', null, array('class'=>'btn btn-lg btn-primary')) }}</p>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Title</th>
				<th>Location</th>
				<th>Time</th>
				<th>Logo</th>
				<th>Institution_id</th>
		</tr>
	</thead>

	<tbody>
		<tr>
			<td>{{{ $bloodevent->title }}}</td>
					<td>{{{ $bloodevent->location }}}</td>
					<td>{{{ $bloodevent->time }}}</td>
					<td>{{{ $bloodevent->logo }}}</td>
					<td>{{{ $bloodevent->institution_id }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('bloodevents.destroy', $bloodevent->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('bloodevents.edit', 'Edit', array($bloodevent->id), array('class' => 'btn btn-info')) }}
                    </td>
		</tr>
	</tbody>
</table>

@stop
