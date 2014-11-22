<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateBloodeventsTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('bloodevents', function(Blueprint $table) {
			$table->increments('id');
			$table->string('title');
			$table->text('location');
			$table->date('time');
			$table->text('logo');
			$table->integer('institution_id');
			$table->timestamps();
		});
	}


	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('bloodevents');
	}

}
