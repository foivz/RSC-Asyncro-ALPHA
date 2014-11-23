<?php
use Faker\Factory as Faker;
class FollowsTableSeeder extends Seeder {

	public function run()
	{
		// Uncomment the below to wipe the table clean before populating
		DB::table('follows')->truncate();
        $faker = Faker::create();
        foreach(range(1, 10) as $index)
        {
            Follow::create([
                'user_id'=>$faker->numberBetween(1,12),
                'institution_id'=>$faker->numberBetween(1,10)
            ]);
        }
		$follows = array(

		);

		// Uncomment the below to run the seeder
		// DB::table('follows')->insert($follows);
	}

}
