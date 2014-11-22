<?php
use Faker\Factory as Faker;
class InstitutionsTableSeeder extends Seeder {

	public function run()
	{
		// Uncomment the below to wipe the table clean before populating
		DB::table('institutions')->truncate();
        $faker = Faker::create();
        foreach(range(1, 10) as $index)
        {
            Institution::create([
                'name' => $faker->name,
                'lat'=>$faker->randomFloat(8, $min = 28.124, 45.67),
                'lng'=>$faker->randomFloat(8, $min = 28.124, 45.67),
                'description'=>$faker->sentence(6),
                'phone'=>$faker->phoneNumber,
                'email'=>$faker->email,
                'city_id' => $faker->numberBetween(1,10),
                'blood_level'=>$faker->randomFloat(2, $min = 12, 100),
                'logo'=>'/uploads/',
                'picture'=>'/uploads/',
                'created_at' => $faker->date()
            ]);
        }
		// Uncomment the below to run the seeder
		// DB::table('institutions')->insert($institutions);
	}

}
