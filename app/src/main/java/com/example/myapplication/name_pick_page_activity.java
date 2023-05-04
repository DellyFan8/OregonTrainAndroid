
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		name_pick_page
	 *	@date 		Sunday 30th of April 2023 07:28:46 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.myapplication;

import static java.lang.System.out;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.GameMech.Person;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

	public class name_pick_page_activity extends Activity {

		static ArrayList<Person> party;

		private View _bg__name_pick_page_ek2;
		private ImageView wagon_1;
		private View advance_button;
		private TextView menu;

		private Button continueButton;
		private EditText name5;
		private EditText name4;
		private EditText name3;
		private EditText name2;
		private EditText name1;
		private View titleblock;
		private TextView menu_ek5;

		@Override
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.name_pick_page);

			continueButton = findViewById(R.id.text);
			_bg__name_pick_page_ek2 = (View) findViewById(R.id._bg__name_pick_page_ek2);
			wagon_1 = (ImageView) findViewById(R.id.wagon_1);
			name5 = findViewById(R.id.name5);
			name4 = findViewById(R.id.name4);
			name3 = findViewById(R.id.name3);
			name2 = findViewById(R.id.name2);
			name1 = findViewById(R.id.name1);
			titleblock = (View) findViewById(R.id.titleblock);
			menu_ek5 = (TextView) findViewById(R.id.menu_ek5);


			//custom code goes here

			continueButton.setOnClickListener(v -> onClick());


		}

		private void onClick() {
			System.out.println(name1.getText().toString() + ", " + name2.getText().toString() + ", " + name3.getText().toString() + ", " + name4.getText().toString() + ", " + name5.getText().toString());

			//set names in program

			openActivity(Main_Game_Activity.class);
		}

		public void openActivity(Class classToOpen) {
			Intent intent = new Intent(this, classToOpen);
			startActivity(intent);
		}

		private void generateNames() {
			Random random = new Random();
			List<String> name = Arrays.asList("John", "William", "James", "George", "Charles", "Joseph", "Robert", "Henry", "Edward", "Thomas", "Samuel", "David", "Frank", "Benjamin", "Andrew", "Peter", "Daniel", "Isaac", "Michael", "Abraham", "Mary", "Elizabeth", "Sarah", "Margaret", "Susan", "Ann", "Jane", "Emily", "Emma", "Catherine", "Caroline", "Martha", "Harriet", "Ellen", "Julia", "Alice", "Rebecca", "Hannah", "Louisa", "Frances");
			out.println("Your Party names: ");

			//Declaring Father Figure
			int namepos = random.nextInt(20);
			String names = name.get(namepos);
			out.println(names);
			int age = random.nextInt(25) + 15;
			party.add(new Person(age, names, 40, Person.Gender.MALE));

			//Declaring Mother
			namepos = random.nextInt(20) + 20;
			names = name.get(namepos);
			out.println(names);
			age = random.nextInt(25) + 15;
			party.add(new Person(age, names, 40, Person.Gender.FEMALE));

			//Children generation
			for (int i = 0; i <= 2; i++) {
				namepos = random.nextInt(name.size());
				names = name.get(namepos);
				out.println(names);
				age = random.nextInt(18);//technically can have kids older than mom and dad...
				if (namepos <= 20) {
					party.add(new Person(age, names, 40, Person.Gender.MALE));
				} else {
					party.add(new Person(age, names, 40, Person.Gender.FEMALE));
				}
			}


		}

	}
	
	