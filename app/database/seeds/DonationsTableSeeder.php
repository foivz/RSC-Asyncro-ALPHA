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
                "user"=>$faker->numberBetween(1,10),
                "institution"=>$faker->numberBetween(1,10),
                "date"=>$faker->dateTimeAD,
                "quantity"=>$faker->numberBetween(200,550),
                "note"=>$faker->sentence(),
                "blood_group"=>$faker->numberBetween(1,10),
                "collecting_blood_event"=>$faker->numberBetween(1,10)
            ]);
        }
		$donations = array(

		);

		// Uncomment the below to run the seeder
		// DB::table('donations')->insert($donations);
	}

}
