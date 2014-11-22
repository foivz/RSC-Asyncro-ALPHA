<?php
use Faker\Factory as Faker;
class CitiesTableSeeder extends Seeder {

	public function run()
	{
		// Uncomment the below to wipe the table clean before populating
		DB::table('cities')->truncate();
        $faker = Faker::create();
        foreach(range(1, 10) as $index)
        {
           City::create([
                'name'=>$faker->city
            ]);
        }
		$cities = array(

		);

		// Uncomment the below to run the seeder
		// DB::table('cities')->insert($cities);
	}

}
