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
		$this->call('BloodeventsTableSeeder');
		$this->call('BloodgroupsTableSeeder');
		$this->call('CitiesTableSeeder');
	}

}
