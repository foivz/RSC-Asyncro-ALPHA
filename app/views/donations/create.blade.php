@extends('layouts.scaffold')

@section('main')

<div class="row">
    <div class="col-md-10 col-md-offset-2">
        <h1>Create Donation</h1>

        @if ($errors->any())
        	<div class="alert alert-danger">
        	    <ul>
                    {{ implode('', $errors->all('<li class="error">:message</li>')) }}
                </ul>
        	</div>
        @endif
    </div>
</div>

{{ Form::open(array('route' => ['donations.store', $ins],'class' => 'form-horizontal')) }}

        <div class="form-group">
               {{ Form::label('user_id', 'User:', array('class'=>'col-md-2 control-label')) }}
              <div class="col-sm-10">
               {{ Form::select('user_id', $users, array('class'=>'form-control', 'placeholder'=>'User')) }}
             </div>
        </div>

        <div class="form-group">
               {{ Form::label('institution', 'Institution:', array('class'=>'col-md-2 control-label')) }}
              <div class="col-sm-10">
               {{ Form::select('institution', $inst, array('class'=>'form-control', 'placeholder'=>'Institution')) }}
             </div>
        </div>

        <div class="form-group">
               {{ Form::label('bloodevents_id', 'Event:', array('class'=>'col-md-2 control-label')) }}
              <div class="col-sm-10">
               {{ Form::select('bloodevents_id', $events, array('class'=>'form-control', 'placeholder'=>'Event')) }}
             </div>
        </div>

        <div class="form-group">
            {{ Form::label('date', 'Date:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('date', Input::old('date'), array('class'=>'form-control', 'placeholder'=>'Date')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('quantity', 'Quantity:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'quantity', Input::old('quantity'), array('class'=>'form-control')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('note', 'Note:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('note', Input::old('note'), array('class'=>'form-control', 'placeholder'=>'Note')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('bloodgroups_id', 'Blood group:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::select('bloodgroups_id', $bloodGroups, array('class'=>'form-control', 'placeholder'=>'Blood group')) }}
            </div>
        </div>


<div class="form-group">
    <label class="col-sm-2 control-label">&nbsp;</label>
    <div class="col-sm-10">
      {{ Form::submit('Create', array('class' => 'btn btn-lg btn-primary')) }}
    </div>
</div>

{{ Form::close() }}

@stop


