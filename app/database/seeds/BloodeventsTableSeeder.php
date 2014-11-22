<?php
use Faker\Factory as Faker;
class BloodeventsTableSeeder extends Seeder {

	public function run()
	{
		// Uncomment the below to wipe the table clean before populating
		// DB::table('bloodevents')->truncate();

        $faker = Faker::create();
        foreach(range(1, 10) as $index)
        {
            Bloodevent::create([
                'title'=>$faker->word,
                'location'=>$faker->city,
                'time'=>$faker->dateTime,
                'logo'=>'/uploads/',
                'institution_id'=>$faker->numberBetween(1,10)
            ]);
        }
		// Uncomment the below to run the seeder
		// DB::table('bloodevents')->insert($bloodevents);
	}

}
