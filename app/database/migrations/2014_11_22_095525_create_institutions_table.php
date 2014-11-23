<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateInstitutionsTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('institutions', function(Blueprint $table) {
			$table->increments('id');
			$table->string('name');
			$table->string('lat');
			$table->string('lng');
			$table->text('description');
			$table->text('phone');
			$table->text('email');
			$table->float('blood_level');
			$table->text('logo');
			$table->text('picture');
            $table->integer('cities_id');
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
		Schema::drop('institutions');
	}

}
