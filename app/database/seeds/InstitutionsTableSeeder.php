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
                'cities_id' => $faker->numberBetween(1,10),
                'blood_level'=>$faker->randomFloat(2, $min = 12, 100),
                'logo'=>'http://us.cdn2.123rf.com/168nwm/romul/romul1212/romul121200019/17009648-shop--illustration.jpg',
                'picture'=>'http://s.hswstatic.com/gif/smithsonian-institution-1.jpg',
                'created_at' => $faker->date()
            ]);
        }
		// Uncomment the below to run the seeder
		// DB::table('institutions')->insert($institutions);
	}

}
