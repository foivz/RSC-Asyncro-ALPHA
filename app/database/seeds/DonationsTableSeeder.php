<?php
use Faker\Factory as Faker;
class DonationsTableSeeder extends Seeder {

	public function run()
	{
		// Uncomment the below to wipe the table clean before populating
		DB::table('donations')->truncate();
        $faker = Faker::create();
        foreach(range(1, 10) as $index)
        {
            Donation::create([
                "user_id"=>$faker->numberBetween(1,10),
                "institution"=>$faker->numberBetween(1,10),
                "date"=>$faker->dateTimeAD,
                "quantity"=>$faker->numberBetween(200,550),
                "note"=>$faker->sentence(),
                "bloodgroups_id"=>$faker->numberBetween(1,8),
                "bloodevents_id"=>$faker->numberBetween(1,10)
            ]);
        }
		$donations = array(

		);

		// Uncomment the below to run the seeder
		// DB::table('donations')->insert($donations);
	}

}
