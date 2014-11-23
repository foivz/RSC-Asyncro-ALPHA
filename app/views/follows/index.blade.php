@extends('layouts.scaffold')

@section('main')

<h1>All Follows</h1>

<p>{{ link_to_route('follows.create', 'Add New Follow', null, array('class' => 'btn btn-lg btn-success')) }}</p>

@if ($follows->count())
	<table class="table table-striped">
		<thead>
			<tr>
				<th>User</th>
				<th>Institution</th>
				<th>&nbsp;</th>
			</tr>
		</thead>

		<tbody>
			@foreach ($follows as $follow)
				<tr>
					<td>{{{ $follow->user }}}</td>
					<td>{{{ $follow->institution }}}</td>
                    <td>
                        {{ Form::open(array('style' => 'display: inline-block;', 'method' => 'DELETE', 'route' => array('follows.destroy', $follow->id))) }}
                            {{ Form::submit('Delete', array('class' => 'btn btn-danger')) }}
                        {{ Form::close() }}
                        {{ link_to_route('follows.edit', 'Edit', array($follow->id), array('class' => 'btn btn-info')) }}
                    </td>
				</tr>
			@endforeach
		</tbody>
	</table>
@else
	There are no follows
@endif

@stop
