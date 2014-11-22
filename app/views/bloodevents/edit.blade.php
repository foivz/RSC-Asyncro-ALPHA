@extends('layouts.scaffold')

@section('main')

<div class="row">
    <div class="col-md-10 col-md-offset-2">
        <h1>Edit Bloodevent</h1>

        @if ($errors->any())
        	<div class="alert alert-danger">
        	    <ul>
                    {{ implode('', $errors->all('<li class="error">:message</li>')) }}
                </ul>
        	</div>
        @endif
    </div>
</div>

{{ Form::model($bloodevent, array('class' => 'form-horizontal', 'method' => 'PATCH', 'route' => array('bloodevents.update', $bloodevent->id))) }}

        <div class="form-group">
            {{ Form::label('title', 'Title:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('title', Input::old('title'), array('class'=>'form-control', 'placeholder'=>'Title')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('location', 'Location:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::textarea('location', Input::old('location'), array('class'=>'form-control', 'placeholder'=>'Location')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('time', 'Time:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('time', Input::old('time'), array('class'=>'form-control', 'placeholder'=>'Time')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('logo', 'Logo:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::textarea('logo', Input::old('logo'), array('class'=>'form-control', 'placeholder'=>'Logo')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('institution_id', 'Institution_id:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'institution_id', Input::old('institution_id'), array('class'=>'form-control')) }}
            </div>
        </div>


<div class="form-group">
    <label class="col-sm-2 control-label">&nbsp;</label>
    <div class="col-sm-10">
      {{ Form::submit('Update', array('class' => 'btn btn-lg btn-primary')) }}
      {{ link_to_route('bloodevents.show', 'Cancel', $bloodevent->id, array('class' => 'btn btn-lg btn-default')) }}
    </div>
</div>

{{ Form::close() }}

@stop