@extends('layouts.scaffold')

@section('main')

<div class="row">
    <div class="col-md-10 col-md-offset-2">
        <h1>Edit Donation</h1>

        @if ($errors->any())
        	<div class="alert alert-danger">
        	    <ul>
                    {{ implode('', $errors->all('<li class="error">:message</li>')) }}
                </ul>
        	</div>
        @endif
    </div>
</div>

{{ Form::model($donation, array('class' => 'form-horizontal', 'method' => 'PATCH', 'route' => array('donations.update', $donation->id))) }}

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
            {{ Form::label('blood_group', 'Blood_group:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'blood_group', Input::old('blood_group'), array('class'=>'form-control')) }}
            </div>
        </div>


<div class="form-group">
    <label class="col-sm-2 control-label">&nbsp;</label>
    <div class="col-sm-10">
      {{ Form::submit('Update', array('class' => 'btn btn-lg btn-primary')) }}
      {{ link_to_route('donations.show', 'Cancel', [$ins, $donation->id], array('class' => 'btn btn-lg btn-default')) }}
    </div>
</div>

{{ Form::close() }}

@stop