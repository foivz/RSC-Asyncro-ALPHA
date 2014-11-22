<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateDonationsTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('donations', function(Blueprint $table) {
			$table->increments('id');
			$table->integer('user_id');
			$table->integer('institution');
			$table->date('date');
			$table->integer('quantity');
			$table->text('note');
			$table->integer('bloodgroups_id');
			$table->integer('bloodevents_id');
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
		Schema::drop('donations');
	}

}
