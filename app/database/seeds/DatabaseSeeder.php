<?php

class DatabaseSeeder extends Seeder {

	/**
	 * Run the database seeds.
	 *
	 * @return void
	 */
	public function run()
	{
		Eloquent::unguard();

		$this->call('UsersTableSeeder');
		$this->call('InstitutionsTableSeeder');
		$this->call('DonationsTableSeeder');
		$this->call('EventsTableSeeder');
		$this->call('Blood_eventsTableSeeder');
		$this->call('BloodeventsTableSeeder');
	}

}
