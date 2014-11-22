<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateUsersTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('users', function(Blueprint $table)
		{
			$table->increments('id');
			$table->string('email')->unique();
			$table->string('password');
            $table->string('name');
            $table->string('surname');
            $table->float('points')->default(0);
            $table->integer('num_of_donations')->default(0);
            $table->text('rank');
            $table->text('avatar');
            $table->integer('blood_group');
            $table->integer('city');
            $table->text('token');
            $table->text('twitterid');
            $table->date('born');
            $table->text('gcm_regid')->nullable();
            $table->rememberToken();
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
		Schema::drop('users');
	}

}