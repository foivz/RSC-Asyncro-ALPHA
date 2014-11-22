@extends('layouts.scaffold')

@section('main')

<div class="row">
    <div class="col-md-10 col-md-offset-2">
        <h1>Edit User</h1>

        @if ($errors->any())
        	<div class="alert alert-danger">
        	    <ul>
                    {{ implode('', $errors->all('<li class="error">:message</li>')) }}
                </ul>
        	</div>
        @endif
    </div>
</div>

{{ Form::model($user, array('class' => 'form-horizontal', 'method' => 'PATCH', 'route' => array('users.update', $user->id))) }}

        <div class="form-group">
            {{ Form::label('email', 'Email:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('email', Input::old('email'), array('class'=>'form-control', 'placeholder'=>'Email')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('password', 'Password:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('password', Input::old('password'), array('class'=>'form-control', 'placeholder'=>'Password')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('name', 'Name:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('name', Input::old('name'), array('class'=>'form-control', 'placeholder'=>'Name')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('surname', 'Surname:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('surname', Input::old('surname'), array('class'=>'form-control', 'placeholder'=>'Surname')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('points', 'Points:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'points', Input::old('points'), array('class'=>'form-control')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('num_of_donations', 'Num_of_donations:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'num_of_donations', Input::old('num_of_donations'), array('class'=>'form-control')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('rank', 'Rank:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('rank', Input::old('rank'), array('class'=>'form-control', 'placeholder'=>'Rank')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('avatar', 'Avatar:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::text('avatar', Input::old('avatar'), array('class'=>'form-control', 'placeholder'=>'Avatar')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('blood_group', 'Blood_group:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'blood_group', Input::old('blood_group'), array('class'=>'form-control')) }}
            </div>
        </div>

        <div class="form-group">
            {{ Form::label('city', 'City:', array('class'=>'col-md-2 control-label')) }}
            <div class="col-sm-10">
              {{ Form::input('number', 'city', Input::old('city'), array('class'=>'form-control')) }}
            </div>
        </div>


<div class="form-group">
    <label class="col-sm-2 control-label">&nbsp;</label>
    <div class="col-sm-10">
      {{ Form::submit('Update', array('class' => 'btn btn-lg btn-primary')) }}
      {{ link_to_route('users.show', 'Cancel', $user->id, array('class' => 'btn btn-lg btn-default')) }}
    </div>
</div>

{{ Form::close() }}

@stop