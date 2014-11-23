<?php
use Faker\Factory as Faker;
class BloodgroupsTableSeeder extends Seeder {

	public function run()
	{
		// Uncomment the below to wipe the table clean before populating
        DB::table('bloodgroups')->truncate();

		$bloodgroups = array(

		);
        $faker = Faker::create();
        Bloodgroup::create([
                'name'=>'A+'
        ]);
        Bloodgroup::create([
            'name'=>'A-'
        ]);
        Bloodgroup::create([
            'name'=>'B+'
        ]);
        Bloodgroup::create([
            'name'=>'B-'
        ]);
        Bloodgroup::create([
            'name'=>'AB+'
        ]);
        Bloodgroup::create([
            'name'=>'AB-'
        ]);
        Bloodgroup::create([
            'name'=>'0+'
        ]);
        Bloodgroup::create([
            'name'=>'0-'
        ]);
		// Uncomment the below to run the seeder
		// DB::table('bloodgroups')->insert($bloodgroups);
	}

}
