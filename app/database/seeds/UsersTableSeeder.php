<?php

// Composer: "fzaninotto/faker": "v1.3.0"
use Faker\Factory as Faker;

class UsersTableSeeder extends Seeder {

	public function run()
	{
        /*
         * Role instantiation
         * */
        $superAdmin = new Role();
        $superAdmin->name = 'SuperAdmin';
        $superAdmin->save();
        $admin = new Role;
        $admin->name = 'Admin';
        $admin->save();
        $manageApp = new Permission();
        $manageApp->name = 'can_manage';
        $manageApp->display_name = 'Can Manage App';
        $manageApp->save();
        $userRole = new Role;
        $userRole->name = 'User';
        $userRole->save();
        $useApp = new Permission();
        $useApp->name = 'can_use';
        $useApp->display_name = 'Can Use App';
        $useApp->save();
        $userRole->attachPermission($useApp);

		$faker = Faker::create();
		foreach(range(1, 10) as $index)
		{
			User::create([
                'email' => $faker->email(),
                'name' => $faker->name(),
                'surname' => $faker->lastName(),
                'points' => $faker->numberBetween(0, 10),
                'num_of_donations' => $faker->numberBetween(0, 10),
                'blood_group' => $faker->numberBetween(1, 4),
                'city' => $faker->numberBetween(1, 10),
                'password' => Hash::make('xxx123'),
                'born' => $faker->date(),
                'created_at' => $faker->date()
			])->attachRole($userRole);
		}
        User::create([
            'email' => 'admin@gmail.com',
            'name' => $faker->name(),
            'surname' => $faker->lastName(),
            'points' => $faker->numberBetween(0, 10),
            'num_of_donations' => $faker->numberBetween(0, 10),
            'blood_group' => $faker->numberBetween(1, 4),
            'city' => $faker->numberBetween(1, 10),
            'password' => Hash::make('xxx123'),
            'born' => $faker->date(),
            'created_at' => $faker->date()
        ]);

        User::where('email','=','admin@gmail.com')->first()->attachRole($admin);

        User::create([
            'email' => 'superadmin@gmail.com',
            'name' => $faker->name(),
            'surname' => $faker->lastName(),
            'points' => $faker->numberBetween(0, 10),
            'num_of_donations' => $faker->numberBetween(0, 10),
            'blood_group' => $faker->numberBetween(1, 4),
            'city' => $faker->numberBetween(1, 10),
            'password' => Hash::make('xxx123'),
            'born' => $faker->date(),
            'created_at' => $faker->date()
        ]);
        User::where('email','=','superadmin@gmail.com')->first()->attachRole($superAdmin);
    }

}