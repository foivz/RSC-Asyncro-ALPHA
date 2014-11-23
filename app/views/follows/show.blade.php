@extends('layouts.scaffold')

@section('main')

<h1>Show Follow</h1>

<p>{{ link_to_route('follows.index', 'Return to All follows', null, array('class'=>'btn btn-lg btn-primary')) }}</p>

<table class="table table-striped">
	<thead>
		<tr>
			<th>User</th>
				<th>Institution</th>
		</tr>
	</thead>

	<tbody>
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
	</tbody>
</table>

@stop
