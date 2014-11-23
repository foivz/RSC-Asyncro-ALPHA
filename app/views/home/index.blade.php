@extends('default.layout')
@section('content')
        @include('partials.preloader')
        <header>
            @include('partials.nav')
            <!--RevSlider-->
             @include('partials.slider')
        </header>
        <div class="wrapper">
            @include('partials.features')
            @include('partials.screens')
            @include('partials.support')
            @include('partials.footer')
        </div>
         @include('includes.scripts')
    </body>
@stop